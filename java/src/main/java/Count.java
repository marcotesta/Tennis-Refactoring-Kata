
public class Count {

    public static final Count FORTY = new Count(3);

    private int value;
    private String playerName;

    private Converter converter = new Converter(){

        public String convert(int value) {
            return "";
        }
    };

    public Count(String aPlayerName) {
        this.value = 0;
        this.playerName = aPlayerName;
    }

    private Count(int aValue) {
        this.value = aValue;
        this.playerName = "";
    }

    public boolean belongTo(String aPlayerName) {
        return playerName.equals(aPlayerName);
    }

    public void increment() {
        value++;
    }

    public boolean even(Count that) {
        return this.value == that.value;
    }

    public boolean greaterThan(Count that) {
        return this.value > that.value;
    }

    public boolean greaterOrEqual(Count that) {
        return this.greaterThan(that) || this.even(that);
    }

    public boolean lessThan(Count that) {
        return !this.greaterOrEqual(that);
    }

    public boolean lessOrEqualThan(Count that) {
        return !this.greaterThan(that);
    }

    public int getValue() {
        return value;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int difference(Count that) {
        return Math.abs(this.value - that.value);
    }


    public Count max(Count that) {
        if (this.value >= that.value) {
            return this;
        } else {
            return that;
        }
    }

    public String asString() {
        return converter.convert(value);
    }

    public void setConverter(Converter converter) {
        this.converter = converter;
    }

}
