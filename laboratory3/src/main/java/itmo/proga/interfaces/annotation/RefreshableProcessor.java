package itmo.proga.interfaces.annotation;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import itmo.proga.item.items.vehicle.Vehicle;
import itmo.proga.entity.character.characters.Passenger;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.IOException;
import java.util.Set;

@SupportedAnnotationTypes("itmo.proga.interfaces.annotation.Refreshable") // Указываем, какие аннотации обрабатываем
@SupportedSourceVersion(SourceVersion.RELEASE_8) // Указываем версию Java
public class RefreshableProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(Refreshable.class)) {
            if (element.getKind() == ElementKind.CLASS) {
                generateMethods((TypeElement) element);
            }
        }
        return true;
    }

    private void generateMethods(TypeElement classElement) {
        String className = classElement.getSimpleName().toString();
        String packageName = processingEnv.getElementUtils().getPackageOf(classElement).toString();

        // Создаем метод refill
        MethodSpec refillMethod = MethodSpec.methodBuilder("refill")
                .addModifiers(Modifier.PUBLIC)
                .returns(void.class)
                .addParameter(int.class, "amount")
                .beginControlFlow("if (this instanceof $T)", Vehicle.class) // Проверка на Vehicle
                .addStatement("this.setFuelLevel(this.getFuelLevel() + amount)")
                .addStatement("System.out.print(\"пополнить \" + amount + \" \" + getType().getFuelType() + \" \")")
                .endControlFlow()
                .beginControlFlow("if (this instanceof $T)", Passenger.class) // Проверка на Passenger
                .addStatement("System.out.print(\"Персонаж не может пополнить топливо \")")
                .endControlFlow()
                .build();

        // Создаем метод consume
        MethodSpec consumeMethod = MethodSpec.methodBuilder("consume")
                .addModifiers(Modifier.PUBLIC)
                .returns(void.class)
                .addParameter(int.class, "amount")
                .addStatement("this.setFuelLevel(this.getFuelLevel() - amount)")
                .beginControlFlow("if (this instanceof $T)", Vehicle.class) // Проверка на Vehicle
                .addStatement("System.out.print(\"использовать \" + amount + \" \" + getType().getFuelType() + \" \")")
                .endControlFlow()
                .beginControlFlow("if (this instanceof $T)", Passenger.class) // Проверка на Passenger
                .beginControlFlow("if (this.isEdibleFuelType())")
                .addStatement("System.out.print(this.getName() + \"потребил \" + amount + \" \" + this.getFuelType() + \" \")")
                .nextControlFlow("else")
                .addStatement("System.out.print(this.getName() + \" не может потребить \" + this.getFuelType() + \" \")")
                .endControlFlow()
                .endControlFlow()
                .build();

        // Создаем класс с добавленными методами
        TypeSpec updatedClass = TypeSpec.classBuilder(className)
                .addModifiers(Modifier.PUBLIC)
                .addMethod(refillMethod)
                .addMethod(consumeMethod)
                .build();

        // Генерируем файл
        JavaFile javaFile = JavaFile.builder(packageName, updatedClass).build();

        // Записываем сгенерированный код в файл
        try {
            javaFile.writeTo(processingEnv.getFiler());
        } catch (IOException e) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Ошибка при генерации кода: " + e.getMessage());
        }
    }
}