package model;

public class Pipe {

    private Type pipeType;

    private boolean outFallCapacity;

    public Pipe(Type pipeType, boolean outFallCapacity) {
        this.pipeType = pipeType;
        this.outFallCapacity = outFallCapacity;
    }

    public Type getPipeType() {
        return pipeType;
    }

    public void setPipeType(Type pipeType) {
        this.pipeType = pipeType;
    }

    public boolean isOutFallCapacity() {
        return outFallCapacity;
    }

    public void setOutFallCapacity(boolean outFallCapacity) {
        this.outFallCapacity = outFallCapacity;
    }
}
