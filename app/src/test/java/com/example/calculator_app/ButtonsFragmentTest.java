package com.example.calculator_app;

import android.os.Build;
import android.widget.Button;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static com.example.support.Assert.assertButtonIsVisibleAndHasLabel;
import static com.example.support.Assert.assertViewIsVisible;
import static com.example.support.ViewLocator.getButton;
import static com.example.support.ViewLocator.getView;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class ButtonsFragmentTest {

    private ButtonsFragment mButtonsFragment;

    @Before
    public void setUp() throws Exception {
        mButtonsFragment = ButtonsFragment.newInstance();
        startFragment(mButtonsFragment);
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(mButtonsFragment);
    }

    @Test
    public void shouldHaveButtons() throws Exception {
        assertViewIsVisible(getView(mButtonsFragment, R.id.fragment_buttons));
    }

    @Test
    public void shouldHaveButtonOne() throws Exception {
        Button buttonOne = getButton(mButtonsFragment, R.id.button_one);
        assertButtonIsVisibleAndHasLabel(buttonOne, R.string.button_one_label);
    }

    @Test
    public void shouldShouldHaveButtonTwo() throws Exception {
        Button buttonTwo = getButton(mButtonsFragment, R.id.button_two);
        assertButtonIsVisibleAndHasLabel(buttonTwo, R.string.button_two_label);
    }

    @Test
    public void shouldHaveButtonThree() throws Exception {
        Button buttonThree = getButton(mButtonsFragment, R.id.button_three);
        assertButtonIsVisibleAndHasLabel(buttonThree, R.string.button_three_label);
    }

    @Test
    public void shouldHaveButtonFour() throws Exception {
        Button buttonFour = getButton(mButtonsFragment, R.id.button_four);
        assertButtonIsVisibleAndHasLabel(buttonFour, R.string.button_four_label);
    }

    @Test
    public void shouldHaveButtonFive() throws Exception {
        Button buttonOne = getButton(mButtonsFragment, R.id.button_five);
        assertButtonIsVisibleAndHasLabel(buttonOne, R.string.button_five_label);
    }

    @Test
    public void shouldShouldHaveButtonSix() throws Exception {
        Button buttonTwo = getButton(mButtonsFragment, R.id.button_six);
        assertButtonIsVisibleAndHasLabel(buttonTwo, R.string.button_six_label);
    }

    @Test
    public void shouldHaveButtonSeven() throws Exception {
        Button buttonThree = getButton(mButtonsFragment, R.id.button_seven);
        assertButtonIsVisibleAndHasLabel(buttonThree, R.string.button_seven_label);
    }

    @Test
    public void shouldHaveButtonEight() throws Exception {
        Button buttonFour = getButton(mButtonsFragment, R.id.button_eight);
        assertButtonIsVisibleAndHasLabel(buttonFour, R.string.button_eight_label);
    }

    @Test
    public void shouldHaveButtonNine() throws Exception {
        Button buttonOne = getButton(mButtonsFragment, R.id.button_nine);
        assertButtonIsVisibleAndHasLabel(buttonOne, R.string.button_nine_label);
    }

    @Test
    public void shouldShouldHaveButtonZero() throws Exception {
        Button buttonTwo = getButton(mButtonsFragment, R.id.button_zero);
        assertButtonIsVisibleAndHasLabel(buttonTwo, R.string.button_zero_label);
    }

    @Test
    public void shouldHavePlus() throws Exception {
        Button buttonThree = getButton(mButtonsFragment, R.id.button_plus);
        assertButtonIsVisibleAndHasLabel(buttonThree, R.string.button_plus_label);
    }

    @Test
    public void shouldHaveButtonMinus() throws Exception {
        Button buttonFour = getButton(mButtonsFragment, R.id.button_minus);
        assertButtonIsVisibleAndHasLabel(buttonFour, R.string.button_minus_label);
    }

    @Test
    public void shouldHaveButtonMultiply() throws Exception {
        Button buttonOne = getButton(mButtonsFragment, R.id.button_multiply);
        assertButtonIsVisibleAndHasLabel(buttonOne, R.string.button_multiply_label);
    }

    @Test
    public void shouldShouldHaveButtonDivide() throws Exception {
        Button buttonTwo = getButton(mButtonsFragment, R.id.button_divide);
        assertButtonIsVisibleAndHasLabel(buttonTwo, R.string.button_divide_label);
    }

    @Test
    public void shouldHaveButtonModulus() throws Exception {
        Button buttonThree = getButton(mButtonsFragment, R.id.button_modulus);
        assertButtonIsVisibleAndHasLabel(buttonThree, R.string.button_modulus_label);
    }

    @Test
    public void shouldHaveButtonEquals() throws Exception {
        Button buttonFour = getButton(mButtonsFragment, R.id.button_equals);
        assertButtonIsVisibleAndHasLabel(buttonFour, R.string.button_equals_label);
    }

    @Test
    public void shouldHaveButtonClear() throws Exception {
        Button buttonFour = getButton(mButtonsFragment, R.id.button_clear);
        assertButtonIsVisibleAndHasLabel(buttonFour, R.string.button_clear_label);
    }

}
