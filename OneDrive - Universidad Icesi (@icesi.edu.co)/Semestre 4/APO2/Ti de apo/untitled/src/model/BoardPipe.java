package model;

public class BoardPipe {

    private BoardPipe next;

    private BoardPipe above;

    private BoardPipe under;

    private BoardPipe previous;

    private Pipe pipe;

    private int row;

    private int column;

    private int indicator;

    public BoardPipe(Pipe pipe, int row, int column, int indicator) {
        this.pipe = pipe;
        this.row = row;
        this.column = column;
        this.indicator = indicator;
    }

    public BoardPipe getNext() {
        return next;
    }

    public void setNext(BoardPipe next) {
        this.next = next;
    }

    public BoardPipe getAbove() {
        return above;
    }

    public void setAbove(BoardPipe above) {
        this.above = above;
    }

    public BoardPipe getUnder() {
        return under;
    }

    public void setUnder(BoardPipe under) {
        this.under = under;
    }

    public BoardPipe getPrevious() {
        return previous;
    }

    public void setPrevious(BoardPipe previous) {
        this.previous = previous;
    }

    public Pipe getPipe() {
        return pipe;
    }

    public void setPipe(Pipe pipe) {
        this.pipe = pipe;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getIndicator() {
        return indicator;
    }

    public void setIndicator(int indicator) {
        this.indicator = indicator;
    }

    public String toString(){
        String out = "";

        if(pipe != null){
            if(pipe.getPipeType() == Type.HORIZONTAL_PIPE){
                out += "[=]";
            }

            if(pipe.getPipeType()== Type.VERTICAL_PIPE){
                out += "[|]";
            }
            if(pipe.getPipeType()== Type.CIRCULAR_PIPE){
                out += "[O]";
            }
            if(pipe.getPipeType()== Type.FONT_PIPE){
                out += "[F]";
            }
            if(pipe.getPipeType()== Type.SEWER_PIPE){
                out += "[S]";
            }
        }else{
            out += "[X]";
        }
        return out;
    }

}