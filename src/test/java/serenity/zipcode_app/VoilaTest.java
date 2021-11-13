package serenity.zipcode_app;

import net.serenitybdd.junit5.SerenityTest;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import serenity.steps.B20Actions;

@SerenityTest
@Tag("voila")
public class VoilaTest {
    @Steps
    B20Actions tucky ;

    // use this approach to create a StepLibrary class for spartan
    // and break down testAdd1Data Test from AdminCRUD_Test into 3 part

    @Test
    public void testVoila(){
        // GIVEN
        tucky.preparedSomething();

        // WHEN
        tucky.takeAnAction();

        // THEN
        tucky.expectSomeResult();




    }

}
