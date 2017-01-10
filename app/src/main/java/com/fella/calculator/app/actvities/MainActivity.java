package com.fella.calculator.app.actvities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.fella.calculator.app.R;


public class MainActivity extends Activity
{
    TextView mResultTv;

    TextView[] mNumberTvs = new TextView[10];
    TextView mAddTv;
    TextView mSubtractTv;
    TextView mMultiplyTv;
    TextView mDivideTv;
    TextView mResetTv;
    TextView mDeleteTv;
    TextView mEqualsTv;
    TextView mOperationTv;

    float mCurrentNumber;
    float mCachedNumber;
    int   mOperation;

    static final int OP_ADD      = 1;
    static final int OP_SUBTRACT = 2;
    static final int OP_MULTIPLY = 3;
    static final int OP_DIVIDE   = 4;

    View.OnClickListener mNumberClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            String viewText = ((TextView) view).getText().toString();
            float  digit    = Float.parseFloat(viewText);
            mCurrentNumber = mCurrentNumber * 10.f + digit;
            updateResult();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultTv = (TextView) findViewById(R.id.tv_result);
        updateResult();

        mNumberTvs[0] = (TextView) findViewById(R.id.tv_0);
        mNumberTvs[1] = (TextView) findViewById(R.id.tv_1);
        mNumberTvs[2] = (TextView) findViewById(R.id.tv_2);
        mNumberTvs[3] = (TextView) findViewById(R.id.tv_3);
        mNumberTvs[4] = (TextView) findViewById(R.id.tv_4);
        mNumberTvs[5] = (TextView) findViewById(R.id.tv_5);
        mNumberTvs[6] = (TextView) findViewById(R.id.tv_6);
        mNumberTvs[7] = (TextView) findViewById(R.id.tv_7);
        mNumberTvs[8] = (TextView) findViewById(R.id.tv_8);
        mNumberTvs[9] = (TextView) findViewById(R.id.tv_9);
        for (TextView tv : mNumberTvs)
        {
            tv.setOnClickListener(mNumberClickListener);
        }

        mAddTv = (TextView) findViewById(R.id.tv_add);
        mAddTv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                doOperation(OP_ADD);
            }
        });

        mSubtractTv = (TextView) findViewById(R.id.tv_subtract);
        mSubtractTv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                doOperation(OP_SUBTRACT);
            }
        });

        mMultiplyTv = (TextView) findViewById(R.id.tv_multiply);
        mMultiplyTv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                doOperation(OP_MULTIPLY);
            }
        });

        mDivideTv = (TextView) findViewById(R.id.tv_divide);
        mDivideTv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                doOperation(OP_DIVIDE);
            }
        });

        mResetTv = (TextView) findViewById(R.id.tv_reset);
        mResetTv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                reset();
            }
        });

        mDeleteTv = (TextView) findViewById(R.id.tv_delete);
        mDeleteTv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                delete();
            }
        });

        mEqualsTv = (TextView) findViewById(R.id.tv_equals);
        mEqualsTv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                calculateResult();
            }
        });

        mOperationTv = (TextView) findViewById(R.id.tv_op);
    }

    private void doOperation(int op)
    {
        mCachedNumber = mCurrentNumber;
        mCurrentNumber = 0;
        mOperation = op;
        updateOperationTv();
    }

    private void updateOperationTv()
    {
        switch (mOperation)
        {
            case OP_ADD:
                mOperationTv.setText("+");
                break;
            case OP_SUBTRACT:
                mOperationTv.setText("-");
                break;
            case OP_MULTIPLY:
                mOperationTv.setText("x");
                break;
            case OP_DIVIDE:
                mOperationTv.setText("/");
                break;
            default:
                mOperationTv.setText("");
                break;
        }
    }

    private void delete()
    {
        mCurrentNumber = (mCurrentNumber - (mCurrentNumber % 10.f)) / 10.f;
        updateResult();
    }

    private void reset()
    {
        mCachedNumber = 0.f;
        mCurrentNumber = 0.f;
        updateResult();
    }

    private void calculateResult()
    {
        float result;
        switch (mOperation)
        {
            case OP_ADD:
                result = mCachedNumber + mCurrentNumber;
                break;
            case OP_SUBTRACT:
                result = mCachedNumber - mCurrentNumber;
                break;
            case OP_MULTIPLY:
                result = mCachedNumber * mCurrentNumber;
                break;
            case OP_DIVIDE:
                if (mCurrentNumber == 0)
                {
                    updateResult("NaN");
                    return;
                } else
                {
                    result = mCachedNumber / mCurrentNumber;
                }
                break;
            default:
                updateResult("Invalid OP");
                return;
        }

        mCurrentNumber = result;
        updateResult();
        mOperationTv.setText("");
    }

    private void updateResult(String message)
    {
        mResultTv.setText(message);
    }

    private void updateResult()
    {
        String resultString = mCurrentNumber + "";
        String afterComma   = resultString.split("\\.")[1];
        if (afterComma.equals("0"))
        {
            resultString = resultString.split("\\.")[0];
        }
        mResultTv.setText(resultString);
    }
}