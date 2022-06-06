package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convert {
    public static <T> List<T> convertArrayToList(T array[])
    {
        return new ArrayList<>(Arrays.asList(array));
//        Arrays.stream(Randomize.getRandom(5, 0, 10)).boxed().collect(Collectors.toList())
    }

    public static int[] covertListToArrayInteger(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
