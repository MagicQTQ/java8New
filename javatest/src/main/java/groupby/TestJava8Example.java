package groupby;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestJava8Example {

	public static void main(String[] args) {

		// List<Integer> lists = Arrays.asList(5,4,3,9,12);
		// Integer ii = lists.stream().reduce(Integer::max).get();
		// System.out.println(ii);

		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300,true),
				new Transaction(raoul, 2012, 1000,true),
				new Transaction(raoul, 2011, 400,true),
				new Transaction(mario, 2012, 710,false), 
				new Transaction(mario, 2012, 700,false), 
				new Transaction(alan, 2012, 950,false));

		// (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
		// (2) 交易员都在哪些不同的城市工作过？
		// (3) 查找所有来自于剑桥的交易员，并按姓名排序。
		

		List<Transaction> list1 = transactions.stream().filter(e -> e.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());

		list1.stream().forEach(System.out::println);
	
		//distinct()函数是去重作用，可以输出toSet来收集
		List<String> list2 = transactions.stream().map(e ->e.getTrader().getCity()).distinct().collect(Collectors.toList());
		
		list2.stream().forEach(System.out::println);
		
		
		 List<Trader> list3 = transactions.stream()
				    .map(Transaction::getTrader) //先取出对应的实体类
					.filter(e ->e.getCity().equals("Cambridge"))
					.distinct()
		            .sorted(Comparator.comparing(Trader::getName))
		            .collect(Collectors.toList());
		
		list3.stream().forEach(System.out::println);
		
		
				// (4) 返回所有交易员的姓名字符串，按字母顺序排序。
				// (5) 有没有交易员是在米兰工作的？
				// (6) 打印生活在剑桥的交易员的所有交易额。
				// (7) 所有交易中，最高的交易额是多少？
				// (8) 找到交易额最小的交易 
		
		String reduce4 = transactions.stream().map(e -> e.getTrader().getName())
							 				.sorted()
							 				.distinct()
//							 				.collect(StringBuilder::joining());
							 				.reduce("", (a, b) -> a +" "+ b);
		System.out.println(reduce4);

		boolean exist5 = transactions.stream().anyMatch(e ->e.getTrader().getCity().equals("Milan"));
		System.out.println(exist5);
		
		
		transactions.stream().filter(e ->e.getTrader().getCity().equals("Cambridge"))
							 .map(Transaction::getValue)
							 .forEach(System.out::println);
//							 .reduce(0,(a,b) ->a+b);
//		System.out.println(sumMoney6);
		
		Integer max7 = transactions.stream().map(e -> e.getValue())
											.reduce(Integer::max).get();
		System.out.println(max7);
		
		Optional<Transaction> min8 = transactions.stream().reduce((t1, t2) ->t1.getValue() < t2.getValue() ? t1 : t2);
		System.out.println(min8.get());
		
		Optional<Integer> min88 = transactions.stream().map(Transaction::getValue).reduce((t1, t2) ->t1 < t2 ? t1 : t2);
		System.out.println("min88:" + min88.orElse(2000));
		
		Optional<Transaction> minEntity8 = transactions.stream().min(Comparator.comparing(Transaction::getValue));
		System.out.println(minEntity8.get());
		
		
		int[] numbers = {2, 3, 5, 7, 11, 13};
		int sum = Arrays.stream(numbers).sum();
		System.out.println(sum);

		//无限流的输出斐波那契数列
		Stream.iterate(new int[]{0, 1},
				t -> new int[]{t[1], t[0]+t[1]})
				.limit(20)
//				.forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
				.map(t ->t[0])
				.forEach(e -> System.out.print(e+","));
		
		Stream.generate((Math::random))
		.limit(5)
		.forEach(System.out::println);
	}

}
