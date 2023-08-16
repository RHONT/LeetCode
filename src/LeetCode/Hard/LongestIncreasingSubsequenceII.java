package LeetCode.Hard;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LongestIncreasingSubsequenceII {
    private Map<Integer, List<Integer>> resultDictionary;


    public static void main(String[] args) {
        LongestIncreasingSubsequenceII l = new LongestIncreasingSubsequenceII();
//        System.out.println(l.lengthOfLIS(new int[]{4, 2, 1, 4, 3, 4, 5, 8, 15}, 3));
//        System.out.println(l.lengthOfLIS(new int[]{1, 5}, 1));
//        System.out.println(l.lengthOfLIS(new int[]{7, 4, 5, 1, 8, 12, 4, 7}, 5));
        System.out.println(l.lengthOfLIS(new int[]{45, 1, 50, 4, 58, 1, 50, 52, 55, 6, 58, 7}, 5));
//        System.out.println(l.lengthOfLIS(new int[]{1, 2, 3, 5, 2}, 1));
//        System.out.println(l.lengthOfLIS(new int[]{77, 100, 40, 41, 42, 3, 4, 5, 300, 49, 52}, 1));
        //   System.out.println(l.lengthOfLIS(new int[]{1709, 5955, 4331, 1386, 9131, 385, 814, 573, 569, 7114, 8628, 2545, 7082, 6467, 6980, 3368, 3331, 7256, 4243, 2461, 7306, 5998, 6703, 5357, 6676, 8857, 2978, 3217, 2762, 5304, 3473, 2589, 704, 2662, 5183, 1874, 6282, 5685, 152, 6947, 2439, 5215, 8070, 4244, 6364, 1149, 3257, 1123, 7928, 1465, 673, 2797, 3996, 7253, 1705, 2163, 3267, 6465, 4906, 578, 7135, 4879, 8774, 2690, 4474, 1742, 4218, 2988, 6241, 7527, 1779, 2280, 9011, 9431, 2175, 6750, 1263, 3969, 6770, 6155, 8371, 722, 8156, 793, 9550, 5425, 2478, 4687, 9359, 5552, 9590, 3111, 7081, 1091, 883, 2682, 4582, 7592, 2777, 85, 1096, 513, 6998, 1818, 1920, 7762, 2331, 8093, 2563, 5361, 4210, 6563, 7112, 1061, 6542, 7234, 3683, 7429, 8583, 4111, 9184, 5794, 780, 8414, 1522, 5113, 2618, 7798, 4432, 7951, 4507, 9723, 7754, 7513, 574, 4627, 7271, 8511, 2739, 6258, 9089, 6803, 8692, 13, 4147, 3356, 2539, 7321, 6301, 3693, 2944, 2658, 3396, 639, 2758, 3833, 4531, 4658, 7831, 3935, 143, 5533, 1268, 498, 8636, 827, 5569, 5564, 5277, 9273, 7890, 6382, 1635, 8877, 1567, 1977, 9458, 1495, 4529, 8306, 8556, 881, 1994, 3961, 1370, 2616, 9684, 5480, 8656, 5829, 8563, 9197, 8046, 6478, 1965, 1885, 4613, 6457, 8696, 4669, 5301, 8709, 1656, 8820, 8254, 89, 4300, 5670, 3300, 2806, 2761, 9249, 8658, 3023, 2584, 5111, 9006, 7636, 1888, 7519, 40, 5987, 3397, 9960, 3875, 8185, 4727, 4059, 4720, 1602, 9853, 8774, 7854, 6547, 2601, 5544, 5308, 9454, 2954, 1243, 233, 9280, 2441, 2189, 4559, 8594, 5887, 7612, 5982, 3264, 9343, 9380, 9488, 7587, 4851, 6498, 4020, 8047, 5122, 168, 3924, 8957, 6410, 5542, 6650, 3342, 9695, 7693, 6370, 9675, 9314, 3310, 3338, 3004, 6649, 3821, 6112, 719, 5455, 5249, 4969, 5267, 6934, 1249, 2726, 1028, 2029, 6048, 9267, 9189, 8457, 1872, 7290, 4169, 7733, 344, 7145, 4275, 8852, 3560, 9930, 6386, 9271, 1504, 1157, 7657, 2982, 3328, 7143, 2607, 7025, 4683, 2293, 9759, 115, 7200, 3826, 299, 3562, 8695, 7361, 9496, 3810, 1030, 3879, 1882, 776, 691, 2300, 7219, 5195, 609, 3421, 7977, 9909, 4573, 1818, 8651, 4074, 892, 409, 2836, 1844, 9706, 7262, 1827, 5845, 8796, 3926, 1687, 108, 7345, 1565, 3100, 1732, 4404, 3027, 2586, 2783, 9981, 8880, 1326, 1751, 4370, 4929, 9223, 5269, 2215, 7795, 8735, 699, 6151, 2764, 834, 8201, 3990, 5897, 9623, 2563, 4775, 2685, 3292, 4724, 3553, 2246, 1889, 7694, 9593, 428, 5220, 9895, 4618, 7861, 6508, 3521, 5291, 3487, 8736, 2309, 7250, 7621, 4879, 7998, 5167, 6548, 360, 4336, 6534, 2180, 6600, 2006, 2002, 8783, 7714, 5322, 5003, 1859, 3237, 5491, 4346, 6179, 7911, 5800, 3784, 8763, 1321, 1864, 125, 7399, 2192, 71, 2984, 7490, 1831, 3853, 8010, 9291, 2674, 1335, 2809, 859, 4822, 4418, 290, 1662, 2227, 8190, 9145, 6890, 9623, 5745, 9739, 5066, 5004, 3749, 8703, 5165, 6412, 8687, 698, 559, 4671, 5020, 2934, 6239, 4632, 6223, 7776, 3850, 2613, 8056, 8879, 9599, 8758, 4429, 9475, 3305, 4720, 9135, 3345, 618, 8328, 4655, 5507, 9108, 4836, 528, 732, 5811, 3330, 1781, 3940, 2471, 7953, 8057, 5039, 3987, 8459, 9053, 5273, 8710, 2990, 6411, 1299, 5101, 6741, 3701, 6241, 6960, 7690, 7078, 8873, 5222, 4117, 2355, 5376, 7386, 7626, 9742, 7849, 3212, 4201, 4192, 4496, 5641, 4354, 3222, 2767, 8015, 5933, 2535, 6314, 2968, 5328, 3328, 4551, 1510, 1054, 9586, 502, 1616, 7586, 219, 8212, 7361, 1213, 7708, 3785, 142, 1852, 1176, 7009, 2472, 1259, 6415, 3531, 512, 5293, 7410, 5368, 8448, 5245, 3482, 3004, 6085, 2293, 883, 5648, 4233, 2845, 8019, 1706, 5051, 7240, 903, 9722, 3702, 791, 5979, 3820, 5855, 4475, 4850, 5433, 8568, 5354, 7212, 9979, 5023, 4076, 9308, 201, 1772, 5291, 6206, 7432, 9820, 8893, 2510, 9332, 6778, 4706, 1192, 3346, 8837, 2237, 8965, 5940, 9336, 3186, 591, 5099, 993, 6105, 3037, 4955, 6395, 4755, 4816, 2599, 5798, 2123, 8785, 8298, 3750, 2632, 1240, 209, 2672, 8295, 8016, 9865, 2453, 7076, 2875, 9982, 7573, 3498, 3709, 6598, 4059, 7489, 1702, 5511, 2605, 3355, 1622, 3548, 5635, 7258, 7866, 7358, 7284, 2586, 5604, 2461, 4347, 6439, 5101, 451, 4375, 7160, 2806, 1944, 9322, 9967, 6053, 1413, 5597, 4336, 9562, 2387, 7114, 931, 3981, 7488, 4619, 5988, 4902, 3259, 8895, 5889, 8229, 4732, 2369, 123, 8119, 5870, 185, 5858, 434, 9181, 933, 6941, 3484, 4246, 4170, 8620, 2610, 399, 5750, 9419, 9801, 3381, 7466, 7495, 3730, 5713, 3887, 9723, 4226, 9477, 160, 8153, 9747, 700, 1373, 3184, 2141, 8854, 8599, 8920, 9550, 6360, 6622, 7157, 2677, 7148, 5528, 665, 1836, 5313, 5653, 3477, 4521, 3102, 9813, 1597, 6509, 3979, 685, 8367, 4483, 1236, 3075, 2944, 6076, 3400, 3368, 7184, 1086, 1416, 7410, 3150, 6043, 6726, 3854, 9495, 7765, 5530, 8894, 4235, 6914, 6378, 9879, 4655, 4191, 184, 2221, 7460, 3567, 2809, 9145, 9918, 1565, 1068, 3362, 4474, 5501, 5231, 1151, 2249, 337, 7918, 363, 309, 3998, 8907, 2247, 5078, 6130, 7571, 8437, 7036, 3586, 2378, 3414, 7447, 7338, 1103, 5915, 1530, 4510, 7847, 94, 1458, 2608, 8634, 828, 5813, 1461, 6408, 5272, 9431, 8230, 7408, 8369, 3620, 1511, 1066, 6220, 8451, 3536, 2739, 2169, 7295, 114, 2020, 1688, 9631, 1384, 70, 9373, 1277, 1099, 1334, 3979, 9482, 8004, 9413, 8595, 5441, 157, 2123, 7037, 8455, 2973, 5486, 2989, 790, 3746, 8505, 8178, 5493, 6266, 8632, 258, 9282, 7766, 9282, 3826, 6174, 5845, 819, 8982, 2560, 2716, 8583, 9494, 597, 6149, 745, 2670, 946, 1339, 5315, 7785, 7334, 3147, 5740, 1431, 5212, 9333, 8424, 8020, 1096, 828, 3546, 3900, 9342, 5223, 439, 4698, 1814, 9027, 4537, 2190, 3007, 7464, 2153, 4515, 5433, 6868, 9113, 9982, 6157, 8578, 317, 7545, 1504, 9082, 3327, 2545, 6741, 8455, 8287, 3298, 3330, 8696, 6863, 1107, 6603, 7846, 5435, 1933, 9184, 8073, 6056, 2258, 5200, 7035, 4473, 1296, 4732, 7882, 8095, 7012, 6407, 7511, 7016, 4385, 9683, 6084, 8443, 1460, 4809, 7599, 6950, 3279, 3599, 2186, 7987, 5128, 9377, 212, 8133, 3337, 9763, 3874, 4111, 7879, 2353, 1182, 5281, 6449, 8515, 3890, 1766, 222, 7680, 9438, 7058, 7134, 8373, 8713, 9019, 8364, 6439, 4316, 9482, 5898, 8008, 5733, 2079, 7674, 6680, 2061, 5657, 9472, 2467, 8418, 1982, 762, 4764, 5201, 8125, 4306, 6754, 7836, 3121}, 4331));
//        System.out.println(l.lengthOfLIS(IntStream.rangeClosed(1, 100000).toArray(), 1));

//        System.out.println(l.lengthOfLIS(new int[]{7, 4, 5, 1, 8, 12, 4, 7}, 5));
//        System.out.println(l.lengthOfLIS(new int[]{1, 20, 21, 2, 3, 4}, 1));
//        System.out.println(l.lengthOfLIS(new int[]{1, 20, 21, 2, 3}, 25));

//        Map<Integer, Integer> t1 = new TreeMap<>(Map.of(1, 2, 2, 3, 4, 5));
//        System.out.println(t1);
//        Map<Integer, Integer> t2 = new TreeMap<>(t1);
//        for (var element : t2.entrySet()) {
//            if (element.getKey() == 1) {
//                element.setValue(100);
//            }
//        }
//        System.out.println(t1);
//        System.out.println(t2);


    }


    public int lengthOfLIS(int[] nums, int k) {

        if (nums.length == 1 || (nums.length == 2 && nums[0] < nums[1])) {
            return 1;
        }
        if (nums.length == 0 || (nums.length == 2 && nums[0] > nums[1])) {
            return 0;
        }

        System.out.println(Arrays.toString(nums));

        System.out.println("**********");
        resultDictionary = getDictionary(nums);

        clearDict(resultDictionary, k);
        if (resultDictionary.size() == nums.length) {
            return nums.length;
        }

//        System.out.println(resultDictionary);
        List<List<Integer>> g = anotherTwo(resultDictionary, nums, k);
//        System.out.println(g);
        List<Integer> resultList = g.stream().max(Comparator.comparing(List::size)).orElseGet(ArrayList::new);
        return resultList.size() > 0 ? resultList.size() : 1;
    }

    private void clearDict(Map<Integer, List<Integer>> resultDictionary, int k) {
        System.out.println("old TreeMap is: " + resultDictionary);
        int current;
        int doubtful;
        int next;
        ListIterator<Integer> iter = new ArrayList<Integer>(resultDictionary.keySet()).listIterator();
        current = iter.next();
        while (iter.hasNext()) {
            next = iter.next();
            if (!(current < next && next - current <= k)) {
                doubtful = next;
                if (iter.hasNext()) {
                    next = iter.next();
                } else {
                    resultDictionary.remove(doubtful);
                    break;
                }

                if (!(doubtful < next && next - doubtful <= k)) {
                    resultDictionary.remove(doubtful);
                    current = iter.previous();
                } else current = next;

            } else {
                current = next;
            }

        }

        System.out.println("new TreeMap is: " + resultDictionary);
    }


    public List<List<Integer>> anotherTwo(Map<Integer, List<Integer>> dict, int[] inputArr, int k) {
        List<List<Integer>> garbage = new ArrayList<>();
        List<Integer> accum = new ArrayList<>();
        List<Integer> setInt = new ArrayList<>(dict.keySet());
        int idxIter = 1;
        int maxSize = 0;
        int startSearch = 0;


        for (var element : dict.entrySet()) {
            int current = element.getKey();

            for (int z = idxIter; z < setInt.size(); z++) {

                ListIterator<Integer> iterInner = setInt.listIterator(z);

                if (!iterInner.hasNext()) {
                    break;
                }
                int next = iterInner.next();
                if (!(current < next && next - current <= k)) {
                    break;

                }


                startSearch = checkInts(current, next);
                if (startSearch == -1) {
                    break;
                }

                accum.add(current);
                accum.add(next);
                current = next;
                for (int i = startSearch + 1; i < inputArr.length; i++) {
                    if (inputArr[i] > current && (inputArr[i] - current) <= k) {
                        accum.add(inputArr[i]);
                        current = inputArr[i];
                    }
                }
                System.out.println(accum);

                if (accum.size() > maxSize) {
                    garbage.add(new ArrayList<>(accum.stream().distinct().collect(Collectors.toList())));
                    maxSize = accum.size();
                }
                accum.clear();
                current = element.getKey();
            }
            idxIter++;

        }
        return garbage;
    }

    private int checkInts(int current, int next) {
        List<Integer> leftElement = resultDictionary.get(current);
        List<Integer> rightElement = resultDictionary.get(next);
        for (var firstElement : leftElement) {
            for (var secondElement : rightElement) {
                if (firstElement < secondElement) {
                    return secondElement;
                }
            }

        }

        return -1;
    }

    public Map<Integer, List<Integer>> getDictionary(int[] inputArr) {

        Map<Integer, List<Integer>> resultDictionary = new TreeMap<>();
        for (int i = 0; i < inputArr.length; i++) {
            if (resultDictionary.containsKey(inputArr[i])) {
                resultDictionary.get(inputArr[i]).add(i);
            } else {
                resultDictionary.put(inputArr[i], new ArrayList<>(List.of(i)));
            }
        }

        return resultDictionary;
    }


}
