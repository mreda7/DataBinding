package com.example.android.architecture.blueprints.todoapp.tasks;


import com.example.android.architecture.blueprints.todoapp.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TasksActivityTest {

    @Rule
    public ActivityTestRule<TasksActivity> mActivityTestRule = new ActivityTestRule<>(TasksActivity.class);

    @Test
    public void tasksActivityTest() {
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab_add_task),
                        withParent(withId(R.id.coordinatorLayout)),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                withId(R.id.add_task_title));
        appCompatEditText.perform(scrollTo(), replaceText("yoyo"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                withId(R.id.add_task_description));
        appCompatEditText2.perform(scrollTo(), replaceText("rdam sid l3awad"), closeSoftKeyboard());

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.fab_edit_task_done),
                        withParent(withId(R.id.coordinatorLayout)),
                        isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.menu_filter), withContentDescription("Filter"), isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.title), withText("Active"), isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction actionMenuItemView2 = onView(
                allOf(withId(R.id.menu_filter), withContentDescription("Filter"), isDisplayed()));
        actionMenuItemView2.perform(click());

        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(R.id.title), withText("Completed"), isDisplayed()));
        appCompatTextView2.perform(click());

        ViewInteraction imageView = onView(
                allOf(withId(R.id.noTasksIcon),
                        childAtPosition(
                                allOf(withId(R.id.noTasks),
                                        childAtPosition(
                                                withId(R.id.tasksContainer),
                                                0)),
                                0),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
