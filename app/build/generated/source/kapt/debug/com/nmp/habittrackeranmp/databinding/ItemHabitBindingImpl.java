package com.nmp.habittrackeranmp.databinding;
import com.nmp.habittrackeranmp.R;
import com.nmp.habittrackeranmp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemHabitBindingImpl extends ItemHabitBinding implements com.nmp.habittrackeranmp.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.viewCompletedIndicator, 9);
        sViewsWithIds.put(R.id.cardIcon, 10);
        sViewsWithIds.put(R.id.txtCompletedMark, 11);
        sViewsWithIds.put(R.id.txtProgressLabel, 12);
    }
    // views
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemHabitBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private ItemHabitBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.button.MaterialButton) bindings[8]
            , (com.google.android.material.button.MaterialButton) bindings[7]
            , (com.google.android.material.card.MaterialCardView) bindings[0]
            , (com.google.android.material.card.MaterialCardView) bindings[10]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.ProgressBar) bindings[6]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[2]
            , (android.view.View) bindings[9]
            );
        this.btnMinus.setTag(null);
        this.btnPlus.setTag(null);
        this.cardHabit.setTag(null);
        this.imgIcon.setTag(null);
        this.progressHabit.setTag(null);
        this.txtHabitDescription.setTag(null);
        this.txtHabitName.setTag(null);
        this.txtProgressValue.setTag(null);
        this.txtStatus.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new com.nmp.habittrackeranmp.generated.callback.OnClickListener(this, 2);
        mCallback3 = new com.nmp.habittrackeranmp.generated.callback.OnClickListener(this, 3);
        mCallback1 = new com.nmp.habittrackeranmp.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.listener == variableId) {
            setListener((com.nmp.habittrackeranmp.view.HabitListener) variable);
        }
        else if (BR.habit == variableId) {
            setHabit((com.nmp.habittrackeranmp.model.Habit) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setListener(@Nullable com.nmp.habittrackeranmp.view.HabitListener Listener) {
        this.mListener = Listener;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }
    public void setHabit(@Nullable com.nmp.habittrackeranmp.model.Habit Habit) {
        this.mHabit = Habit;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.habit);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String habitName = null;
        int habitGoal = 0;
        com.nmp.habittrackeranmp.view.HabitListener listener = mListener;
        java.lang.String habitIcon = null;
        boolean habitProgressHabitGoal = false;
        com.nmp.habittrackeranmp.model.Habit habit = mHabit;
        int habitProgress = 0;
        java.lang.String habitProgressHabitGoalTxtStatusAndroidStringCompletedTxtStatusAndroidStringInProgress = null;
        java.lang.String habitDescription = null;

        if ((dirtyFlags & 0x6L) != 0) {



                if (habit != null) {
                    // read habit.name
                    habitName = habit.getName();
                    // read habit.goal
                    habitGoal = habit.getGoal();
                    // read habit.icon
                    habitIcon = habit.getIcon();
                    // read habit.progress
                    habitProgress = habit.getProgress();
                    // read habit.description
                    habitDescription = habit.getDescription();
                }


                // read habit.progress >= habit.goal
                habitProgressHabitGoal = (habitProgress) >= (habitGoal);
            if((dirtyFlags & 0x6L) != 0) {
                if(habitProgressHabitGoal) {
                        dirtyFlags |= 0x10L;
                }
                else {
                        dirtyFlags |= 0x8L;
                }
            }


                // read habit.progress >= habit.goal ? @android:string/completed : @android:string/in_progress
                habitProgressHabitGoalTxtStatusAndroidStringCompletedTxtStatusAndroidStringInProgress = ((habitProgressHabitGoal) ? (txtStatus.getResources().getString(R.string.completed)) : (txtStatus.getResources().getString(R.string.in_progress)));
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.btnMinus.setOnClickListener(mCallback3);
            this.btnPlus.setOnClickListener(mCallback2);
            this.txtHabitName.setOnClickListener(mCallback1);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.nmp.habittrackeranmp.view.BindingAdapterKt.setHabitIcon(this.imgIcon, habitIcon);
            this.progressHabit.setMax(habitGoal);
            this.progressHabit.setProgress(habitProgress);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtHabitDescription, habitDescription);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtHabitName, habitName);
            com.nmp.habittrackeranmp.view.BindingAdapterKt.setProgressDetail(this.txtProgressValue, habit);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtStatus, habitProgressHabitGoalTxtStatusAndroidStringCompletedTxtStatusAndroidStringInProgress);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // habit
                com.nmp.habittrackeranmp.model.Habit habit = mHabit;
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.nmp.habittrackeranmp.view.HabitListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {



                    listener.onPlus(habit);
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // habit
                com.nmp.habittrackeranmp.model.Habit habit = mHabit;
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.nmp.habittrackeranmp.view.HabitListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {



                    listener.onMinus(habit);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // habit
                com.nmp.habittrackeranmp.model.Habit habit = mHabit;
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.nmp.habittrackeranmp.view.HabitListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {



                    listener.onTitle(habit);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): listener
        flag 1 (0x2L): habit
        flag 2 (0x3L): null
        flag 3 (0x4L): habit.progress >= habit.goal ? @android:string/completed : @android:string/in_progress
        flag 4 (0x5L): habit.progress >= habit.goal ? @android:string/completed : @android:string/in_progress
    flag mapping end*/
    //end
}