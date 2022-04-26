package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Convert {
    public static <T> List<T> convertArrayToList(T array[])
    {
        return new ArrayList<>(Arrays.asList(array));
    }
}
