package cosc426.program.slidingpuzzle;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class AppInterface extends RelativeLayout {

    private Board board;
    private Board goal;
    private Button Left;
    private Button Down;
    private Button Up;
    private Button Right;


    public AppInterface(Context context, int size, OnClickListener[] buttonHandlers){
        super(context);

        final int DP = (int)(getResources().getDisplayMetrics().density);
        this.setBackgroundColor(Color.parseColor("#DBCF27"));

        //Game Board
        board = new Board(context, size, 100*DP);
        board.setId(GridLayout.generateViewId());
        LayoutParams params = new LayoutParams(0,0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.topMargin = 20*DP;
        board.setLayoutParams(params);
        addView(board);

        //Goal Board
        goal = new Board(context, size, 100*DP);
        goal.setId(GridLayout.generateViewId());
        params = new LayoutParams(0,0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.addRule(RelativeLayout.BELOW, board.getId());
        params.topMargin = 20*DP;
        goal.setLayoutParams(params);
        addView(goal);

        //Centerpiece
        TextView centerpiece = new TextView(context);
        centerpiece.setId(TextView.generateViewId());
        params = new LayoutParams(0,0);
        params.height = LayoutParams.WRAP_CONTENT;
        params.width = LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.addRule(RelativeLayout.BELOW, goal.getId());
        params.topMargin = 10*DP;
        centerpiece.setLayoutParams(params);
        addView(centerpiece);

        //Buttons
        //Down
        Down = new Button(context);
        Down.setId(Button.generateViewId());
        Down.setText("\\/");
        Down.setBackgroundColor(Color.parseColor("#CCE5FF"));
        Down.setGravity(Gravity.CENTER);
        params = new LayoutParams(0,0);
        params.width = 100*DP;
        params.height = 100*DP;
        params.addRule(RelativeLayout.LEFT_OF, centerpiece.getId());
        params.addRule(RelativeLayout.BELOW, goal.getId());
        params.topMargin = 10*DP;
        params.leftMargin = 10*DP;
        params.rightMargin =10*DP;
        Down.setOnClickListener(buttonHandlers[1]);
        Down.setLayoutParams(params);
        addView(Down);

        //Left
        Left = new Button(context);
        Left.setId(Button.generateViewId());
        Left.setText("<");
        Left.setBackgroundColor(Color.parseColor("#CCE5FF"));
        Left.setGravity(Gravity.CENTER);
        params = new LayoutParams(0,0);
        params.width = 100*DP;
        params.height = 100*DP;
        params.addRule(RelativeLayout.LEFT_OF, Down.getId());
        params.addRule(RelativeLayout.BELOW, goal.getId());
        params.topMargin = 10*DP;
        Left.setOnClickListener(buttonHandlers[0]);
        Left.setLayoutParams(params);
        addView(Left);

        //Right
        Right = new Button(context);
        Right.setId(Button.generateViewId());
        Right.setText(">");
        Right.setBackgroundColor(Color.parseColor("#CCE5FF"));
        Right.setGravity(Gravity.CENTER);
        params = new LayoutParams(0,0);
        params.width = 100*DP;
        params.height = 100*DP;
        params.rightMargin = 10*DP;
        params.addRule(RelativeLayout.RIGHT_OF, centerpiece.getId());
        params.addRule(RelativeLayout.BELOW, goal.getId());
        params.topMargin = 10*DP;
        Right.setOnClickListener(buttonHandlers[2]);
        Right.setLayoutParams(params);
        addView(Right);

        //Up
        Up = new Button(context);
        Up.setId(Button.generateViewId());
        Up.setText("/\\");
        Up.setBackgroundColor(Color.parseColor("#CCE5FF"));
        Up.setGravity(Gravity.CENTER);
        params = new LayoutParams(0,0);
        params.width = 100*DP;
        params.height = 100*DP;
        params.addRule(RelativeLayout.RIGHT_OF, Right.getId());
        params.addRule(RelativeLayout.BELOW, goal.getId());
        params.topMargin = 10*DP;
        Up.setOnClickListener(buttonHandlers[3]);
        Up.setLayoutParams(params);
        addView(Up);


    }
    //send to board
    public void updateBoard(int[][] boardValues){
        board.update(boardValues);
    }
    //send to goal
    public void updateGoal(int[][] boardValues){
        goal.update(boardValues);
    }
}