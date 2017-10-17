package com.heilos.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamTest {
	public static void main(String[] args) {
		/*
		 * IntStream.range(0, 10).boxed().forEach(value ->
		 * System.out.println(value));
		 * 
		 * 
		 * long count = IntStream.range(1, 100).count();
		 * System.out.println(count);
		 */

		// IntStream.range(0, 100).collect(()->1,
		// (t,r)->System.out.println("23"), (t,u)->{System.out.println("1");});
		Double collect = IntStream.range(0, 100).boxed().collect(Collectors.toList()).stream()
				.collect(Collectors.averagingInt(item -> item));
		System.out.println(collect);

		// 对列表 进行统计
		List<Integer> list = IntStream.range(1, 100).boxed().collect(Collectors.toList());
		IntSummaryStatistics iss = list.stream().collect(Collectors.summarizingInt(value -> value));
		System.out.println(iss);
		// list 转 map
		Map<Integer, Integer> map = list.stream().collect(Collectors.toMap(p -> p, q -> q * 3));
		System.out.println(map);
		// 求列表最大元素
		List<Integer> list1 = new Random().ints(-100, 0).limit(250).boxed().collect(Collectors.toList());
		Optional<Integer> max = list1.stream().reduce(Math::max);
		max.ifPresent(value -> System.out.println(value));
		// 从一堆姓名列表中找出以字母“C”开头的姓名
		String[] names = { "Fred Edwards", "Anna Cox", "Deborah Patterson", "Ruth Torres", "Shawn Powell",
				"Rose Thompson", "Rachel Barnes", "Eugene Ramirez", "Earl Flores", "Janice Reed", "Sarah Miller",
				"Patricia Kelly", "Carl Hall", "Craig Wright", "Martha Phillips", "Thomas Howard", "Steve Martinez",
				"Diana Bailey", "Kathleen Hughes", "Russell Anderson", "Theresa Perry" };
		List<String> ls = Arrays.asList(names).stream().filter(s -> s.startsWith("C")).collect(Collectors.toList());
		System.out.println(ls.toString());
		// 把所有的姓名大写、排序，再输出
		Arrays.asList(names).stream().map(String::toUpperCase).sorted().forEach(System.out::println);
	}
}
