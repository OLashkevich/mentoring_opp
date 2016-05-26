package com.epam.aircompany.plane;

import com.epam.aircompany.exeption.NegativeRangeException;

import java.util.Comparator;

/**
 * @author Olga Lashkevich
 */
public abstract class Airplane implements IAirplane {

    private String _class = getClass().getName();
    private String name;
    private int range;

    public Airplane() {
    }

    public Airplane(String name, int range) throws NegativeRangeException {
        this.name = name;
        if (range > 0) {
            this.range = range;
        } else {
            throw new NegativeRangeException("Error: range is negative or zero", range);
        }
    }

    public String getName() {
        return name;
    }

    public int getRange() {
        return range;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public String toString() {
        return "\n" + getClass().getSimpleName() + ": " + name + " Range: " + range;
    }

    public static Comparator<IAirplane> rangeComparator() {
        return new Comparator<IAirplane>() {
            public int compare(IAirplane o1, IAirplane o2) {
                return Integer.compare(o1.getRange(), o2.getRange());
            }
        };
    }

    public static Comparator<IAirplane> passengerCapacityComparator() {
        return new Comparator<IAirplane>() {
            public int compare(IAirplane o1, IAirplane o2) {
                return Integer.compare(o1.getSeatingCapacity(), o2.getSeatingCapacity());
            }
        };
    }

    public static Comparator<IAirplane> carryingCapacityComparator() {
        return new Comparator<IAirplane>() {
            public int compare(IAirplane o1, IAirplane o2) {
                return Integer.compare(o1.getCarryingCapacity(), o2.getCarryingCapacity());
            }
        };
    }

}
