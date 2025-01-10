package com.seomantra.jobportal.controller;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		
		Predicate<Integer> predicate = x->x%2==0;
		Function<Integer, Integer> function = x->x * x;
		Consumer<Integer> consumer = x -> System.out.println(x);
		Supplier<Integer> supplier = ()->100;
		
		if(predicate.test(supplier.get())) {
			consumer.accept(function.apply(supplier.get()));
		}

		BiPredicate<Integer, Integer> issumEven = (x,y)->(x+y)%2 ==0;
		System.out.println(issumEven.test(5, 5));
		BiConsumer<Integer, String> biconsumer = (x,y)->{
	         System.out.println(x);
	         System.out.println(y); 
	};
	
	BiFunction<String, String, Integer> bifunction = (x,y)->(x+y).length();
	System.out.println(bifunction.apply("a", "bc"));
	
	List<String> students = Arrays.asList("ram","shyam","aman");
	students.forEach(System.out::println);
	
	// process collection of data in a functional and declrative manner
	// simplyfie data processing
	//enable functional programming 
	// Improve Readability and Maintainabilily
	// Enable Easy Parallelism
	
	List<Integer> num = Arrays.asList(1,2,3,4,5,6,7,8,9);
	 System.out.println(num.stream().filter(x->x%2==0).count());
	
	 // creating stream 
	 // 1. From Collection 
	 List<Integer> list = Arrays.asList(1,3,4,5,67,78);
	 Stream<Integer> stream = list.stream();
	 
	 //2. from Arrays
	  String []array = {"a","b","c","d"};
	  Stream<String> s1= Arrays.stream(array);
	 
	 // 3. Using Stream.of()
	  Stream<String> s2 = Stream.of("a","b","c");
	  
	 // 4. Infinite Stream 
	  Stream<Integer> generate = Stream.generate(()->1);
	  Stream.iterate(1,x->x+1);
	 
	  //1. filter
	  List<String> list1 = Arrays.asList("akshit","ram","Shyam","Pankaj");
	   System.out.println(list1.stream().filter(x->x.startsWith("A")).count());
	   
	  //2. map
	     System.out.println(list1.stream().map(String::toUpperCase));
	   
	  // 3.sorted
	     System.out.println(list1.stream().sorted());
	     
	  // 4. Distinct
	     System.out.println(list1.stream().filter(x->x.startsWith("A")).distinct().count());
	     
	  // 5. collect 
	      list1.stream().skip(1).collect(Collectors.toList());
	      list1.stream().skip(1).toList();
	      
	  // 6. forEach
	      list1.stream().forEach(x->System.out.println(x));
	      
	  //7. Consume 
	     // Optional<Integer> optionalInteger = list1.stream().reduce(Integer::sum);
	     // System.out.println(optionalInteger.get());
	     
	     //8. chars (to convert in intstream, counting occurance of character) 
	     String str = "ashish";
	     System.out.println("************************"+str.chars().filter(x->x =='s').count());
	     
	  //  9.  peek (perform an action on each element as it is consumed)
	     Stream.iterate(1, x->x+1).skip(10).limit(100).peek(System.out::print).count();
	     
	   //10. min/max
	     System.out.println("maxStream.");
	     
	   // 11. flatmap 
	     List<String> str2 = Arrays.asList("Hello World","Java stream","optional");
	       System.out.println(str2.stream().flatMap(x->Arrays.stream(x.split(""))).map(String::toUpperCase).toList());
	       
	   //12. summarizing data 
	     //  Generates statics summary
	       IntSummaryStatistics stats = num.stream().collect(Collectors.summarizingInt(x->x));
	       System.out.println(stats.getCount());
	       
	   //13. Write a Java 8 program to filter even numbers from a list 
	       List<Integer> list2 = Arrays.asList(1,2,34,67,78,234,68,23,22);
	     System.out.println(list2.stream().filter(x->x%2==0).collect(Collectors.toList()));
	     
	   //14. Write a Java 8 program to calculate the sum of integers in a list
	     System.out.println(list2.stream().reduce(0,Integer::sum));
	     
	    //15. Write a Java 8 program to find the maximum element from a list ? 
	   System.out.println(list2.stream().max(Integer::compareTo));
	   
	   //16. Write a Java 8 program to check if a list contains a specific element
	     System.out.println(list2.stream().anyMatch(x->x == 14));
	     
	   //17. Write a Java 8 program to find the sum of all even numbers in a list of integers 
	    System.out.println(list2.stream().filter(x->x%2 ==0).mapToInt(x->x).sum());
	    
	    
	    //18. Write a Java 8 program to concatenate all strings in a list 
	    List<String> str1 = List.of("apple", "banana", "orange", "grape", "kiwi");
	       System.out.println(str1.stream().collect(Collectors.joining()));
	   
	     //19.  Write a Java 8 program to find the average length of strings in a list of strings  
	    System.out.println(str1.stream().mapToInt(String::length).average().orElse(0.0));
	    
	    //20. Write a Java 8 program to count the occurrences of a given character in a list of strings
	    System.out.println("*************" + str1.stream().flatMapToInt(CharSequence::chars).filter(ch->ch == 'a').count());
	    
	    //21. Write a Java 8 program to check if all elements in a list are greater than a given value?
	      System.out.println(list2.stream().allMatch(x -> x > 234));

	  // 22. Write a Java 8 program to find the factorial of a given number 

//	      int n = 3;
//	      int factorila = factorialCalculate(n);
//	      System.out.println(factorila);
//	  
//           public static int factorialCalculate(int n) {
//	    	  return IntStream.rangeClosed(1, n).reduce(1, (a,b)->a*b);
//     	} 
	   
	 //23. Write a Java 8 program to remove duplicate elements from a list
           List<Integer> list3 = Arrays.asList(1, 2, 2, 3, 4, 4, 5);     
          System.out.println(list3.stream().collect(Collectors.toSet()));
           
    //24. Write a Java 8 program to find the longest string in a list of strings 
        System.out.println(str1.stream().max((a,b)-> a.length()- b.length()).get());
        
     //25. Write a Java 8 program to convert all strings to uppercase in a list 
      System.out.println(str1.stream().map(String::toUpperCase).collect(Collectors.toList()));
           
     //26. Write a Java 8 program to sort a list of strings in alphabetical order    
          System.out.println(str1.stream().sorted().collect(Collectors.toList()));
      
     //27. Write a Java 8 program to calculate the average of even numbers in a list of integers
      System.out.println(list2.stream().filter(x->x%2==0).mapToInt(x->x).average().getAsDouble());
      
     //28. Write a Java 8 program to find the second smallest element in a list of integers 
      System.out.println(list2.stream().sorted().skip(1).findFirst().get());
      
     //29. Write a Java 8 program to find the frequency of each word in a list of strings
         System.out.println(str1.stream()
        		             .flatMap(x->List.of(x.split("\\s+"))
        		             .stream())
        		             .collect(Collectors.groupingBy(String::toLowerCase,Collectors.counting())));     
      
//     30. Write a Java 8 program to find the sum of digits of a list of integers
            System.out.println(list2.stream().reduce(Integer::sum).get());
         
//     31. Write a Java 8 program to find the distinct characters in a list of strings 
            List<String> strings1 = List.of("apple", "banana", "cherry");
            System.out.println(strings1.stream().flatMapToInt(String::chars).mapToObj(x->(char) x).collect(Collectors.toSet()));
            
            
//     32. Write Java 8 program to find all the numbers starting with 2 in given list 
//     33. Write Java 8 program to find the first element of the given integers list
//     34. Write Java 8 program to count the total numbers of elements in the given integers list.
//     35. Write Java 8 program to sort all the values of the list in ascending order.
//     36. Write Java 8 program to sort all the values of the list in descending order.
//     37. Write Java 8 program to check if given integer array contains duplicate or not. Return true if it contains duplicate character.
//     38. Write a Java 8 program to concatenate two Streams
//     39. Write Java 8 program to perform square on list elements and filter numbers greater than 1000.
//     40. Write Java 8 program to separate odd and even numbers from the given list of integers
//     41. Write Java 8 program to print the numbers which are multiples of 3.
//     42. Write Java 8 program to merge two unsorted arrays into single sorted array
//     43. Write Java 8 program to merge two unsorted arrays into single sorted array by removing duplicates?
//     44. Java program to get first three maximum numbers and three minimum numbers from the given list of integers?
//     45. Java 8 program to check if two strings are anagrams or not
//     46.  Write Java 8 program to find sum of all digits of a number 
//     47. Write Java 8 program to sort given list of strings according to decreasing order of their length? 
//     48. Write Java 8 program to find common elements between two lists
//     49. Write Java 8 program to prints the first 5 odd numbers 
//     50. Write Java 8 program to print the most repeated element in an array.
//     51. Write Java 8 program to print duplicate elements from an array.
//     52. Write Java 8 program to find first repeated character in the given string.
//     53. Write a Java 8 program to check if a list contains a specific string.
//     54. Write a Java 8 program print all the strings of given length 
//     55. Write a Java 8 program print first non repetitive character in the string 
//     56. Write a Java 8 program to find the product of all elements in a list.
//     57. Write a Java 8 program to check if all elements in a list are unique.
//     58. Write a Java 8 program to find the first word in a list that starts with given letter.
//     59. Write a Java 8 program to find the sum of the first 10 natural numbers.
//     60. Write a Java 8 program to find the product of the first 10 natural numbers. 
      
      
}   
} 	

	

