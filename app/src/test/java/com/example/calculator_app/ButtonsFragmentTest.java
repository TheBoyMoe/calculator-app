package com.example.calculator_app;

import android.os.Build;
import android.widget.Button;

import com.example.calculator_app.events.BaseEvent;
import com.example.calculator_app.events.NumberEvent;
import com.example.support.BusHelper;
import com.squareup.otto.Bus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import static com.example.support.Assert.assertButtonIsVisibleAndHasLabel;
import static com.example.support.Assert.assertViewIsVisible;
import static com.example.support.ViewLocator.getButton;
import static com.example.support.ViewLocator.getView;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class ButtonsFragmentTest {

    private ButtonsFragment mButtonsFragment;
    private Button mButtonOne;
    private Button mButtonTwo;
    private Button mButtonThree;
    private Button mButtonFour;
    private Button mButtonFive;
    private Button mButtonSix;
    private Button mButtonSeven;
    private Button mButtonEight;
    private Button mButtonNine;
    private Button mButtonZero;
    private Button mButtonPlus;
    private Button mButtonMinus;
    private Button mButtonMultiply;
    private Button mButtonDivide;
    private Button mButtonModulus;
    private Button mButtonEquals;
    private Button mButtonClear;
    private BusHelper mBusHelper;

    @Before
    public void setUp() throws Exception {

        // register the event bus helper in order to receive events
        mBusHelper = new BusHelper();
        CalculatorApplication.getInstance().getBus().register(mBusHelper);

        mButtonsFragment = ButtonsFragment.newInstance();
        startFragment(mButtonsFragment);
        mButtonOne = getButton(mButtonsFragment, R.id.button_one);
        mButtonTwo = getButton(mButtonsFragment, R.id.button_two);
        mButtonThree = getButton(mButtonsFragment, R.id.button_three);
        mButtonFour = getButton(mButtonsFragment, R.id.button_four);
        mButtonFive = getButton(mButtonsFragment, R.id.button_five);
        mButtonSix = getButton(mButtonsFragment, R.id.button_six);
        mButtonSeven = getButton(mButtonsFragment, R.id.button_seven);
        mButtonEight = getButton(mButtonsFragment, R.id.button_eight);
        mButtonNine = getButton(mButtonsFragment, R.id.button_nine);
        mButtonZero = getButton(mButtonsFragment, R.id.button_zero);
        mButtonPlus = getButton(mButtonsFragment, R.id.button_plus);
        mButtonMinus = getButton(mButtonsFragment, R.id.button_minus);
        mButtonMultiply = getButton(mButtonsFragment, R.id.button_multiply);
        mButtonDivide = getButton(mButtonsFragment, R.id.button_divide);
        mButtonModulus = getButton(mButtonsFragment, R.id.button_modulus);
        mButtonEquals = getButton(mButtonsFragment, R.id.button_equals);
        mButtonClear = getButton(mButtonsFragment, R.id.button_clear);
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(mButtonsFragment);
    }

    @Test
    public void shouldHaveButtons() throws Exception {
        assertViewIsVisible(getView(mButtonsFragment, R.id.fragment_buttons));
    }

    // verify buttons present and correct label applied
    @Test
    public void shouldHaveButtonOne() throws Exception {
        assertButtonIsVisibleAndHasLabel(mButtonOne, R.string.button_one_label);
    }

    @Test
    public void shouldShouldHaveButtonTwo() throws Exception {
        assertButtonIsVisibleAndHasLabel(mButtonTwo, R.string.button_two_label);
    }

    @Test
    public void shouldHaveButtonThree() throws Exception {
        assertButtonIsVisibleAndHasLabel(mButtonThree, R.string.button_three_label);
    }

    @Test
    public void shouldHaveButtonFour() throws Exception {
        assertButtonIsVisibleAndHasLabel(mButtonFour, R.string.button_four_label);
    }

    @Test
    public void shouldHaveButtonFive() throws Exception {
        assertButtonIsVisibleAndHasLabel(mButtonFive, R.string.button_five_label);
    }

    @Test
    public void shouldShouldHaveButtonSix() throws Exception {
        assertButtonIsVisibleAndHasLabel(mButtonSix, R.string.button_six_label);
    }

    @Test
    public void shouldHaveButtonSeven() throws Exception {
        assertButtonIsVisibleAndHasLabel(mButtonSeven, R.string.button_seven_label);
    }

    @Test
    public void shouldHaveButtonEight() throws Exception {
        assertButtonIsVisibleAndHasLabel(mButtonEight, R.string.button_eight_label);
    }

    @Test
    public void shouldHaveButtonNine() throws Exception {
        assertButtonIsVisibleAndHasLabel(mButtonNine, R.string.button_nine_label);
    }

    @Test
    public void shouldShouldHaveButtonZero() throws Exception {
        assertButtonIsVisibleAndHasLabel(mButtonZero, R.string.button_zero_label);
    }

    @Test
    public void shouldHavePlus() throws Exception {
        assertButtonIsVisibleAndHasLabel(mButtonPlus, R.string.button_plus_label);
    }

    @Test
    public void shouldHaveButtonMinus() throws Exception {
        assertButtonIsVisibleAndHasLabel(mButtonMinus, R.string.button_minus_label);
    }

    @Test
    public void shouldHaveButtonMultiply() throws Exception {
        assertButtonIsVisibleAndHasLabel(mButtonMultiply, R.string.button_multiply_label);
    }

    @Test
    public void shouldShouldHaveButtonDivide() throws Exception {
        assertButtonIsVisibleAndHasLabel(mButtonDivide, R.string.button_divide_label);
    }

    @Test
    public void shouldHaveButtonModulus() throws Exception {
        assertButtonIsVisibleAndHasLabel(mButtonModulus, R.string.button_modulus_label);
    }

    @Test
    public void shouldHaveButtonEquals() throws Exception {
        assertButtonIsVisibleAndHasLabel(mButtonEquals, R.string.button_equals_label);
    }

    @Test
    public void shouldHaveButtonClear() throws Exception {
        assertButtonIsVisibleAndHasLabel(mButtonClear, R.string.button_clear_label);
    }


    // verify button interaction
    @Test
    public void buttonOneShouldPostEvent() throws Exception {
        verifyNumberEvent(mButtonOne);
    }

    @Test
    public void buttonTwoShouldPostEvent() throws Exception {
        verifyNumberEvent(mButtonTwo);
    }

    @Test
    public void buttonThreeShouldPostEvent() throws Exception {
        verifyNumberEvent(mButtonThree);
    }

    @Test
    public void buttonFourShouldPostEvent() throws Exception {
        verifyNumberEvent(mButtonFour);
    }

    @Test
    public void buttonFiveShouldPostEvent() throws Exception {
        verifyNumberEvent(mButtonFive);
    }

    @Test
    public void buttonSixShouldToastOnClick() throws Exception {
        verifyNumberEvent(mButtonSix);
    }

    @Test
    public void buttonSevenShouldPostEvent() throws Exception {
        verifyNumberEvent(mButtonSeven);
    }

    @Test
    public void buttonEightShouldPostEvent() throws Exception {
        verifyNumberEvent(mButtonEight);
    }

    @Test
    public void buttonNineShouldPostEvent() throws Exception {
        verifyNumberEvent(mButtonNine);
    }

    @Test
    public void buttonZeroShouldPostEvent() throws Exception {
        verifyNumberEvent(mButtonZero);
    }

    @Test
    public void buttonPlusShouldPostEvent() throws Exception {
        verifyOperatorButtonShouldToast(mButtonPlus);
    }

    @Test
    public void buttonMinusShouldPostEvent() throws Exception {
        verifyOperatorButtonShouldToast(mButtonMinus);
    }

    @Test
    public void buttonDivideShouldPostEvent() throws Exception {
        verifyOperatorButtonShouldToast(mButtonDivide);
    }

    @Test
    public void buttonMultiplyShouldPostEvent() throws Exception {
        verifyOperatorButtonShouldToast(mButtonMultiply);
    }

    @Test
    public void buttonModulusShouldPostEvent() throws Exception {
        verifyOperatorButtonShouldToast(mButtonModulus);
    }

    @Test
    public void buttonEqualsShouldPostEvent() throws Exception {
        verifyEqualsButtonShouldToast(mButtonEquals);
    }

    @Test
    public void buttonClearShouldPostEvent() throws Exception {
        verifyClearButtonShouldToast(mButtonClear);
    }



    private void verifyNumberEvent(Button button) {
        button.performClick();
        BaseEvent event = mBusHelper.getLastEvent();
        assertTrue(event instanceof NumberEvent);
        assertThat(((NumberEvent)event).getNumber(),
                equalTo(button.getText()));
    }

    private void verifyOperatorButtonShouldToast(Button button) {
        button.performClick();
        assertThat(ShadowToast.getTextOfLatestToast(), equalTo(button.getText()));
    }


    private void verifyEqualsButtonShouldToast(Button button) throws Exception {
        button.performClick();
        assertThat(ShadowToast.getTextOfLatestToast(), equalTo(button.getText()));
    }

    private void verifyClearButtonShouldToast(Button button) throws Exception {
        button.performClick();
        assertThat(ShadowToast.getTextOfLatestToast(), equalTo(button.getText()));
    }
}
