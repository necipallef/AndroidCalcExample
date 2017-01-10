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
    TextView mDelete;
    TextView mEquals;

    int mCurrentNumber;

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
            mCurrentNumber = Integer.parseInt(viewText);
            mResultTv.setText(mCurrentNumber + "");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultTv = (TextView) findViewById(R.id.tv_result);
        mResultTv.setText(mCurrentNumber + "");

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

        mDelete = (TextView) findViewById(R.id.tv_delete);
        mDelete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                delete();
            }
        });

        mEquals = (TextView) findViewById(R.id.tv_equals);
        mEquals.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                calculateResult();
            }
        });
    }

    private void doOperation(int op)
    {
        switch (op)
        {
            case OP_ADD:
                // TODO
                break;
            case OP_SUBTRACT:
                // TODO
                break;
            case OP_MULTIPLY:
                // TODO
                break;
            case OP_DIVIDE:
                // TODO
                break;
            default:
                // TODO
                break;
        }
    }

    private void delete()
    {
        // TODO
    }

    private void calculateResult()
    {
        // TODO
        mResultTv.setText(mCurrentNumber + "");
    }
}