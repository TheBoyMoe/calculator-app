package com.example.calculator_app;

import android.os.Build;
import android.support.annotation.NonNull;

import com.example.calculator_app.events.AppendEvent;
import com.example.calculator_app.events.BaseEvent;
import com.example.calculator_app.events.ClearEvent;
import com.example.calculator_app.events.NumberEvent;
import com.example.calculator_app.events.OperatorEvent;
import com.example.calculator_app.events.SetDisplayEvent;
import com.example.calculator_app.model.Operator;
import com.example.support.BusHelper;
import com.squareup.otto.Bus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static com.example.calculator_app.CalculatorStateFragment.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class CalculatorStateFragmentTest {


    public static final String NUMBER_VALUE = "1";
    private static final Operator OPERATOR = Operator.MODULO;
    private static final int OPERAND_LENGTH = 3;
    private static final Operator OPERATOR2 = Operator.PLUS;
    private CalculatorStateFragment mStateFragment;
    private Bus mBus;
    private BusHelper mBusHelper;


    @Before
    public void setUp() throws Exception {
        mStateFragment = newInstance();
        startFragment(mStateFragment);

        mBus = CalculatorApplication.getInstance().getBus();
        mBusHelper = new BusHelper();
        mBus.register(mBusHelper);
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(mStateFragment);
    }


    @Test
    public void numberEventShouldFireAppendEvent() throws Exception {
        postNumberEvent();

        BaseEvent event = mBusHelper.getLastEvent();
        assertTrue(event instanceof AppendEvent);
        assertThat(mBusHelper.numberOfEvents(), equalTo(2));
        assertThat(((AppendEvent) event).getValue(), equalTo(NUMBER_VALUE));
    }

    @Test
    public void shouldSetDisplayAfterOperatorEvent() throws Exception {

        postNumberEvent();
        postOperatorEvent(OPERATOR);
        postNumberEvent();
        assertDisplayEventWithValue(NUMBER_VALUE);

    }

    @Test
    public void operatorEventShouldFireSetEvent() throws Exception {
        constructDefaultOperand();
        postOperatorEvent(OPERATOR);
        assertDisplayEventWithValue(OPERATOR.getOperatorString());
    }

    @Test
    public void operandShouldNotExceedMaxLength() throws Exception {
        constructToLongOperand();
        assertThat(mStateFragment.getOperand().length(),
                equalTo(MAX_OPERAND_LENGTH));
    }

    @Test
    public void shouldStoreCorrectMaxOperandValue() throws Exception {
        constructToLongOperand();
        assertOperandEquals(maxTestOperand());
    }

    @Test
    public void shouldConstructOperand() throws Exception {
        String expectedOperand = constructOperand(OPERAND_LENGTH);
        assertOperandEquals(expectedOperand);
    }

    @Test
    public void shouldResetOperandAfterOperator() throws Exception {
        constructOperand(OPERAND_LENGTH);
        postOperatorEvent(OPERATOR);
        assertOperandEquals(DEFAULT_OPERAND);
    }

    @Test
    public void shouldConstructNumberAfterOperator() throws Exception {
        constructOperand(OPERAND_LENGTH);
        postOperatorEvent(OPERATOR);
        String expectedEvent = constructOperand(OPERAND_LENGTH + 2);
        assertOperandEquals(expectedEvent);
    }

    @Test
    public void clearShouldClearOperand() throws Exception {
        postNumberEvent();
        postClearEvent();
        assertThat(mStateFragment.getOperand(), equalTo(DEFAULT_OPERAND));
    }

    @Test
    public void clearShouldClearOperator() throws Exception {
        postNumberEvent();
        postClearEvent();
        assertThat(mStateFragment.getOperator(), equalTo(Operator.NONE));
    }

    @Test
    public void shouldBeAbleToChangeOperators() throws Exception {
        constructDefaultOperand();
        postOperatorEvent(OPERATOR);
        postOperatorEvent(OPERATOR2);
        assertThat(mStateFragment.getOperator(), equalTo(OPERATOR2));

    }

    @Test
    public void shouldNotUpdateOperatorOrOperandBeforeANumber() throws Exception {
        postOperatorEvent(OPERATOR);
        assertThat(mStateFragment.getOperator(), equalTo(Operator.NONE));
        assertThat(mStateFragment.getOperand(), equalTo(DEFAULT_OPERAND));
    }

    @Test
    public void operatorShouldNotFireSetDisplayEventBeforeANUmberIsEntered() throws Exception {
        postOperatorEvent(OPERATOR);
        assertThat(mBusHelper.getEventListSize(), equalTo(1));
        assertTrue(mBusHelper.getLastEvent() instanceof OperatorEvent);
    }

    private void assertDisplayEventWithValue(String value) {
        BaseEvent lastEvent = mBusHelper.getLastEvent();
        assertTrue(lastEvent instanceof SetDisplayEvent);
        assertThat(((SetDisplayEvent) lastEvent).getValue(), equalTo(value));
    }

    private void constructDefaultOperand() {
        constructOperand(OPERAND_LENGTH);
    }

    private void assertOperandEquals(String expectedOperand) {
        assertThat(mStateFragment.getOperand(), equalTo(expectedOperand));
    }

    private String constructOperand(int operandLength) {
        return constructOperandMaybePost(operandLength, true);
    }

    @NonNull
    private String constructOperandMaybePost(int operandLength, boolean shouldPost) {
        String operand = "";
        for (int operandCounter = 1;
                operandCounter <= operandLength;
                operandCounter++) {

            if(shouldPost) {
                postNumberEvent();
            }
            operand += NUMBER_VALUE;
        }
        return operand;
    }

    private String maxTestOperand() {
        return constructOperandMaybePost(MAX_OPERAND_LENGTH, false);
    }

    private void constructToLongOperand() {
        constructOperand(MAX_OPERAND_LENGTH + 2);
    }

    private void postOperatorEvent(Operator operator) {
        mBus.post(new OperatorEvent(operator));
    }

    private void postNumberEvent() {
        // post a number event to the bus and check that it triggers an append event
        mBus.post(new NumberEvent(NUMBER_VALUE));
    }

    private void postClearEvent() {
        mBus.post(new ClearEvent());
    }


}