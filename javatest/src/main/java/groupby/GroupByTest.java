package groupby;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class GroupByTest {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Trader> traderList = Arrays.asList(raoul, mario, alan, brian);
        List<Transaction> transactionList = Arrays.asList(
                new Transaction(brian, 2011, 300, true),
                new Transaction(raoul, 2012, 1000, true),
                new Transaction(raoul, 2011, 400, true),
                new Transaction(mario, 2012, 710, false),
                new Transaction(mario, 2012, 700, false),
                new Transaction(alan, 2012, 950, false));

        // 拼接字符串
        String names = traderList.stream().map(Trader::getName).sorted().collect(Collectors.joining(","));
        System.out.println(names);

        // 求平均数
        Double average = transactionList.stream().collect(Collectors.averagingInt(Transaction::getValue));

        // IntSummaryStatistics{count=6, sum=4060, min=300, average=676.666667,
        // max=1000}
        IntSummaryStatistics summary1 = transactionList.stream()
                .collect(Collectors.summarizingInt(Transaction::getValue));

        LongSummaryStatistics summary2 = transactionList.stream()
                .collect(Collectors.summarizingLong(Transaction::getValue));

        DoubleSummaryStatistics summary3 = transactionList.stream()
                .collect(Collectors.summarizingDouble(Transaction::getValue));

        System.out.println(average);

        System.out.println(summary1);
        System.out.println(summary1.getMax());
        System.out.println(summary1.getAverage());
        System.out.println(summary1.getCount());
        System.out.println(summary1.getCount());

        // 求和
        int totalCalories = transactionList.stream()
                .collect(Collectors.reducing(0, Transaction::getValue, (i, j) -> i + j));
        // 拼接字符串
        String joining = traderList.stream().collect(Collectors.reducing("", Trader::getName, (i, j) -> i + j + ","));
        System.out.println(joining);

        // total1 == total2
        int total1 = transactionList.stream().mapToInt(Transaction::getValue).sum();
        int total2 = transactionList.stream().map(Transaction::getValue).reduce(0, Integer::sum);
        int total3 = transactionList.stream().map(Transaction::getValue).reduce(Integer::sum).get();

        //IntStream 求和
        long count = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0).sum(); // range不包含100，rangeClosed包含100
        System.out.println(count);


        // 按照年份进行分组
        Map<Integer, List<Transaction>> maps = transactionList.stream()
                .collect(Collectors.groupingBy(Transaction::getYear));
        System.out.println(maps);

        // 按照年份进行分组,统计个数
        Map<Integer, Long> mapsCount = transactionList.stream()
                .collect(Collectors.groupingBy(Transaction::getYear, Collectors.counting()));
        System.out.println("mapsCount:---" + mapsCount);

        Set<Entry<Integer, Long>> entrySet = mapsCount.entrySet();
        for (Entry<Integer, Long> entry : entrySet) {
            System.out.println(entry.getKey() + "============" + entry.getValue());
        }

        // 按照年份进行分组,统计各种信息【最大值，最小值，平均值，求和，个数】
        Map<Integer, IntSummaryStatistics> collectMap = transactionList.stream()
                .collect(Collectors.groupingBy(Transaction::getYear, Collectors.summarizingInt(Transaction::getValue)));
        System.out.println(collectMap);

        collectMap.forEach((k, v) -> System.out.println("k：" + k + "，value：" + v));
//        Set<Entry<Integer, IntSummaryStatistics>> collectSet = collectMap.entrySet();
//        for (Entry<Integer, IntSummaryStatistics> entry : collectSet) {
//            System.out.println(entry.getKey() + "============" + entry.getValue());
//        }

        //按照年龄分组，拿到各年龄组的交易者的
        Map<Integer, List<Trader>> listMap = transactionList.stream()
                .collect(Collectors.groupingBy(Transaction::getYear, Collectors.mapping(Transaction::getTrader, Collectors.toList())));

        listMap.forEach((k, v) -> System.out.println("key:" + k + "，value:" + v));


        // 分区函数，根据true或者false值来分区
        Map<Boolean, List<Transaction>> partitionMap = transactionList.stream()
                .collect(Collectors.partitioningBy(Transaction::getFlag));
        System.out.println(partitionMap);
        Set<Entry<Boolean, List<Transaction>>> partitionSet = partitionMap.entrySet();
        for (Entry<Boolean, List<Transaction>> entry : partitionSet) {
            System.out.println(entry.getKey() + "============" + entry.getValue());
        }

        // 等价于filter，但是返回值不一样
        List<Transaction> flagList = transactionList.stream().filter(Transaction::getFlag).collect(Collectors.toList());
        flagList.stream().forEach(System.out::println);

        // 但是partitioningBy()的功能很强大，可以根据true或者flag先分好区，在进行年份进行分组
        Map<Boolean, Map<Integer, List<Transaction>>> partitionMap2 = transactionList.stream()
                .collect(Collectors.partitioningBy(Transaction::getFlag, Collectors.groupingBy(Transaction::getYear)));
        System.out.println(partitionMap2);

        //根据Value大于700 为true的进行分区，返回 true；小于700，则返回false；然后各自在true和false分区里面再根据年份分组
        Map<Boolean, Map<Integer, List<Transaction>>> partitionMap4 = transactionList.stream()
                .collect(Collectors.partitioningBy(e -> e.getValue() >= 700, Collectors.groupingBy(Transaction::getYear)));
        System.out.println("partitionMap4：" + partitionMap4);
        partitionMap4.forEach((k, v) -> System.out.println(k + "===========partitionMap4============" + v));

        Set<Entry<Boolean, Map<Integer, List<Transaction>>>> partitionSet2 = partitionMap2.entrySet();
        for (Entry<Boolean, Map<Integer, List<Transaction>>> entry : partitionSet2) {
            System.out.println(entry.getKey() + "################" + entry.getValue());
        }

        // 可以分成多个区
        Map<Boolean, Long> partitionMap3 = transactionList.stream()
                .collect(Collectors.partitioningBy(Transaction::getFlag, Collectors.counting()));
        System.out.println(partitionMap3);

        Set<Entry<Boolean, Long>> partitionSet3 = partitionMap3.entrySet();
        for (Entry<Boolean, Long> entry : partitionSet3) {
            System.out.println(entry.getKey() + "........" + entry.getValue());
        }

        long start1 = System.currentTimeMillis();
        // System.out.println("结果是："+rangedSum(1_000_000_000));
        System.out.println("结果是：" + parallelRangedSum(1_000_000_000));
        long end1 = System.currentTimeMillis();

        long time = end1 - start1;
        System.out.println("耗时：" + time);
    }

    // 流的方式求和
    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
    }
}
