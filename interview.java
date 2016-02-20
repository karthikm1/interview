import java.util.*;

class interview {
	public static void main(String[] args) {
		String input = "tHIS is a Sample";
		System.out.println(splParse("b,\"a,b\""));
		System.out.println(removeDups("abcdba"));
		System.out.println(firstNonRepeatedChar("abcdba"));
		System.out.println(capitalize(input));
		System.out.println(reverse(input));
		System.out.println(reverseWords(input));
		System.out.println(isStringRotated("abc", "cba"));
		System.out.println(isAnagram("abc", "cca"));
		System.out.println(isPalindrome("abba"));
		System.out.println(reverseNum(209));
		System.out.println(DecToBin(10));
	}
    
	/**
    
    */
	public static void printFib(int num) {
		if (num <= 0) return;
		if (num == 1) {
			System.out.println ("0");
			return;
		}
		System.out.print ("0 1");
		if (num == 2) {
			System.out.println();
			return;
		}
		int fib0 = 0;
		int fib1 = 1;
		for (int i = 3; i <=num; i++) {
			int fib = fib0 + fib1; 
			System.out.print (" " + fib);
			fib0 = fib1;
			fib1 = fib;
		}
		System.out.println();
	}
    
    /**
    */	
	public static List<String> splParse(String str) {
		List<String> result = new ArrayList<String>();
		boolean quotesOn = false;
		StringBuilder sb = new StringBuilder();
		for (char c : str.toCharArray()) {
			switch (c) {
			case ',':
				if (quotesOn) sb.append(c);
				else {
					result.add(sb.toString());
					sb = new StringBuilder();
				}
				break;
			case '\"':
				quotesOn = !quotesOn;
				break;
			default:
				sb.append(c);
					break;
			}
		}
		result.add(sb.toString());
		return result;
	}
	
   	/**
    
    */
	static String removeDups(String str) {
		HashSet hs = new HashSet();
		StringBuilder sb = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (!hs.contains(c)) {
				sb.append(c);
				hs.add(c);
			} 
		}
		return sb.toString();
	}

	/**
    
    */	
	static Character firstNonRepeatedChar(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : str.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c,map.get(c) +1);
			} else {
				map.put(c,1);
			}
		}
		
		for (char c : str.toCharArray()) {
			if (map.get(c) ==1 ) return c;	
		}
		return null;
	}

	/**
    
    */
	static String capitalize(String str) {
		// scan through the string
		// if you see a space set flag to capitalize char
		// for all other chars if capitalize flag is set, capitalize & 
		StringBuilder sb = new StringBuilder();
		boolean capitalizeChar = true;
		for (char c : str.toCharArray()) {
			switch (c) {
				case ' ':
					capitalizeChar = true;
					sb.append(c);
					break;
				default:
					if (capitalizeChar) {
						sb.append(Character.toUpperCase(c));
						capitalizeChar = false;
					} else {
						sb.append(Character.toLowerCase(c));
					}
					break;
			}
		}
		return sb.toString();
	}

	/**
    
    */
	static String reverse(String str) {
		StringBuilder result = new StringBuilder();
		for (int i = str.length() -1; i>=0; i--) {
			result.append(str.charAt(i));
		}
		return result.toString();
	}

	/**
    
    */
	static String reverseWords(String str) {
		String reverse = reverse(str);
		String[] words = reverse.split("\\s");
		StringBuilder result = new StringBuilder();
		for (String word : words) {
			result.append(reverse(word));
			result.append(" ");
		}
		result.deleteCharAt(result.length() - 1);
		return result.toString();
	}
	
	static boolean isStringRotated(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		return (str2+str2).contains(str1);
	}
	
	static boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		HashMap<Character, Integer> map = new HashMap<Character,Integer> ();
		for (char c : str1.toCharArray()) {
			if (map.containsKey(c)) map.put(c, map.get(c) + 1);
			else map.put(c,1);
		}
		for (char c : str2.toCharArray()) {
			if (map.containsKey(c)) {
				int val = map.get(c) -1;
				if (val < 0) return false;
				map.put(c, val);	
			} 
			else return false;
		}
		return true;
	}
	
	static boolean isPalindrome(String str) {
		for (int i = 0; i < str.length()/2; i++) {
			if (str.charAt(i) != str.charAt(str.length() -1 -i)) return false;
		}
		return true;
	}
	
	static int reverseNum(int num) {
		int reverse = 0;
		while (num > 0) {
			int digit = num % 10;
			reverse *= 10;
			reverse += digit;
			num /= 10;
		}
		return reverse;
	}
	
	static String DecToBin(int num){
		if (num == 0) return "";
		return DecToBin(num/2) + num%2;
	}
	
	static String nextPalindrome(int num) {
		String imput = num.toString();
		for (int i = str.length()/2; i>=0; i--) {
			if (str.charAt(i) != str.charAt(str.length() -1 -i)) return false;
		}
	}

/*
Problem 1:
Writing coding interview questions hasn't made me rich. Maybe trading Apple stocks will.
Suppose we could access yesterday's stock prices as an array, where:

The indices are the time in minutes past trade opening time, which was 9:30am local time.
The values are the price in dollars of Apple stock at that time.
So if the stock cost $500 at 10:30am, stockPricesYesterday[60] = 500.

Write an efficient function that takes stockPricesYesterday and returns the best profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.

For example:
  int[] stockPricesYesterday = new int[]{10, 7, 5, 8, 11, 9};

getMaxProfit(stockPricesYesterday);
// returns 6 (buying for $5 and selling for $11)
No "shorting"—you must buy before you sell. You may not buy and sell in the same time step (at least 1 minute must pass).
*/

/*
Problem 2:
You have an array of integers, and for each index you want to find the product of every integer except the integer at that index.
Write a function getProductsOfAllIntsExceptAtIndex() that takes an array of integers and returns an array of the products.

For example, given:
  [1, 7, 3, 4]
 your function would return:
  [84, 12, 28, 21]
 by calculating:
  [7*3*4, 1*3*4, 1*7*4, 1*7*3]
Do not use division in your solution.
*/

/* 
Problem 3:
Given an arrayOfInts, find the highestProduct you can get from three of the integers.
The input arrayOfInts will always have at least three integers.
*/

/*
Problem 4:
Your company built an in-house calendar tool called HiCal. You want to add a feature to see the times in a day when everyone is available.
To do this, you’ll need to know when any team is having a meeting. In HiCal, a meeting is stored as an object of a Meeting class with integer variables startTime and endTime. These integers represent the number of 30-minute blocks past 9:00am.

  public class Meeting {

    int startTime;
    int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public String toString() {
        return String.format("(%d, %d)", startTime, endTime);
    }
}
For example:

new Meeting(2, 3); // meeting from 10:00 – 10:30 am
new Meeting(6, 9); // meeting from 12:00 – 1:30 pm

Write a function condenseMeetingTimes() that takes a list of meeting time ranges and returns a list of condensed ranges.

For example, given:

  [(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)]

your function would return:

  [(0, 1), (3, 8), (9, 12)]

Do not assume the meetings are in order. The meeting times are coming from multiple teams.

In this case the possibilities for startTime and endTime are bounded by the number of 30-minute slots in a day. But soon you plan to refactor HiCal to store times as Unix timestamps (which are big numbers). Write something that's efficient even when we can't put a nice upper bound on the numbers representing our time ranges.
*/

/*
Problem 5:
Imagine you landed a new job as a cashier...
Your quirky boss found out that you're a programmer and has a weird request about something they've been wondering for a long time.

Write a function that, given:

an amount of money
an array of coin denominations
computes the number of ways to make amount of money with coins of the available denominations.

Example: for amount=44 (44¢) and denominations=[1,2,3][1,2,3] (11¢, 22¢ and 33¢), your program would output 44—the number of ways to make 44¢ with those denominations:

1¢, 1¢, 1¢, 1¢
1¢, 1¢, 2¢
1¢, 3¢
2¢, 2¢
*/

/*
Problem 6:
A crack team of love scientists from OkEros (a hot new dating site) have devised a way to represent dating profiles as rectangles on a two-dimensional plane.
They need help writing an algorithm to find the intersection of two users' love rectangles. They suspect finding that intersection is the key to a matching algorithm so powerful it will cause an immediate acquisition by Google or Facebook or Obama or something.

Write a function to find the rectangular intersection of two given love rectangles.

As with the example above, love rectangles are always "straight" and never "diagonal." More rigorously: each side is parallel with either the x-axis or the y-axis.

They are defined as objects of Rectangle class:

  public class Rectangle {

    // coordinates of bottom left corner
    Integer x;
    Integer y;

    // dimensions
    Integer width;
    Integer height;

    public Rectangle(Integer x, Integer y, Integer width, Integer height) {
        this.x = x;
        this.y = y;
        this.width  = width;
        this.height = height;
    }

    public Rectangle() {}

    public String toString() {
        return String.format("(%d, %d, %d, %d)", x, y, width, height);
    }
}
Your output rectangle should be a Rectangle object as well.
*/

/*
Problem 7:
You decide to test if your oddly-mathematical heating company is fulfilling its All-Time Max, Min, Mean and Mode Temperature Guarantee™.
Write a class TempTracker with these methods:

insert()—records a new temperature
getMax()—returns the highest temp we've seen so far
getMin()—returns the lowest temp we've seen so far
getMean()—returns the mean ↴ of all temps we've seen so far
getMode()—returns the mode ↴ of all temps we've seen so far
Optimize for space and time. Favor speeding up the getter functions (getMax(), getMin(), getMean(), and getMode()) over speeding up the insert() function.

getMean() should return a float, but the rest of the getter functions can return integers. Temperatures will all be inserted as integers. We'll record our temperatures in Fahrenheit, so we can assume they'll all be in the range 0..1100..110.

If there is more than one mode, return any of the modes.
*/

/*
Problem 8:
Write a function to see if a binary tree ↴ is "superbalanced" (a new tree property we just made up).
A tree is "superbalanced" if the difference between the depths of any two leaf nodes is no greater than one.

Here's a sample binary tree node class:

  public static class BinaryTreeNode {

    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode insertLeft(int leftValue) {
        this.left = new BinaryTreeNode(leftValue);
        return this.left;
    }

    public BinaryTreeNode insertRight(int rightValue) {
        this.right = new BinaryTreeNode(rightValue);
        return this.right;
    }
}
*/

/*
Problem 10:
Write a function to find the 2nd largest element in a binary search tree ↴ .
Here's a sample binary tree node class:

  public static class BinaryTreeNode {

    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode insertLeft(int leftValue) {
        this.left = new BinaryTreeNode(leftValue);
        return this.left;
    }

    public BinaryTreeNode insertRight(int rightValue) {
        this.right = new BinaryTreeNode(rightValue);
        return this.right;
    }
}
*/

/*
Problem 11:
I'm making a search engine called MillionGazillion™.
I wrote a crawler that visits web pages, stores a few keywords in a database, and follows links to other web pages. I noticed that my crawler was wasting a lot of time visiting the same pages over and over, so I made a hash map visited where I'm storing URLs I've already visited. Now the crawler only visits a URL if it hasn't already been visited.

Thing is, the crawler is running on my old desktop computer in my parents' basement (where I totally don't live anymore), and it keeps running out of memory because visited is getting so huge.

How can I trim down the amount of space taken up by visited?
*/

/*
Problem 12:

*/

/*
Problem 12:
Suppose we had an array ↴ of nn integers in sorted order. How quickly could we check if a given integer is in the array?
*/

/*
Problem 13:
I want to learn some big words so people think I'm smart.
I opened up a dictionary to a page in the middle and started flipping through, looking for words I didn't know. I put each word I didn't know at increasing indices in a huge array I created in memory. When I reached the end of the dictionary, I started from the beginning and did the same thing until I reached the page I started at.

Now I have an array of words that are mostly alphabetical, except they start somewhere in the middle of the alphabet, reach the end, and then start from the beginning of the alphabet. In other words, this is an alphabetically ordered array that has been "rotated." For example:

  String[] words = new String[]{
    "ptolemaic",
    "retrograde",
    "supplant",
    "undulate",
    "xenoepist",
    "asymptote", // <-- rotates here!
    "babka",
    "banoffee",
    "engender",
    "karpatka",
    "othellolagkage",
};

Write a function for finding the index of the "rotation point," which is where I started working from the beginning of the dictionary. This array is huge (there are lots of words I don't know) so we want to be efficient here.
*/
/*
Problem 14:
You've built an in-flight entertainment system with on-demand movie streaming.
Users on longer flights like to start a second movie right when their first one ends, but they complain that the plane usually lands before they can see the ending. So you're building a feature for choosing two movies whose total runtimes will equal the exact flight length.

Write a function that takes an integer flightLength (in minutes) and an array of integers movieLengths (in minutes) and returns a boolean indicating whether there are two numbers in movieLengths whose sum equals flightLength.

When building your function:

Assume your users will watch exactly two movies
Don't make your users watch the same movie twice
Optimize for runtime over memory
*/
/*
Problem 15:
Write a function fib() that a takes an integer nn and returns the nnth fibonacci ↴ number.
Let's say our fibonacci series is 0-indexed and starts with 0. So:

  fib(0) # => 0
fib(1) # => 1
fib(2) # => 1
fib(3) # => 2
fib(4) # => 3
...
*/

/*
Problem 16:
You are a renowned thief who has recently switched from stealing precious metals to stealing cakes because of the insane profit margins. You end up hitting the jackpot, breaking into the world's largest privately owned stock of cakes—the vault of the Queen of England.
While Queen Elizabeth has a limited number of types of cake, she has an unlimited supply of each type.

Each type of cake has a weight and a value, stored in objects of a CakeType class:

  class CakeType {

    int weight;
    int value;

    public CakeType(int weight, int value) {
        this.weight = weight;
        this.value  = value;
    }

}
Java
For example:

  // weighs 7 kilograms and has a value of 160 pounds
new CakeType(7, 160);

// weighs 3 kilograms and has a value of 90 pounds
new CakeType(3, 90);

You brought a duffel bag that can hold limited weight, and you want to make off with the most valuable haul possible.

Write a function maxDuffelBagValue() that takes an array of cake type objects and a weight capacity, and returns the maximum monetary value the duffel bag can hold.

For example:

  CakeType[] cakeTypes = new CakeType[]{
    new CakeType(7, 160),
    new CakeType(3, 90),
    new CakeType(2, 15),
};

int capacity = 20;

maxDuffelBagValue(cakeTypes, capacity);
// returns 555 (6 of the middle type of cake and 1 of the last type of cake)

Weights and values may be any non-negative integer. Yes, it's weird to think about cakes that weigh nothing or duffel bags that can't hold anything. But we're not just super mastermind criminals—we're also meticulous about keeping our algorithms flexible and comprehensive.
*/
/*
Problem 17:
If we execute this Javascript, what will the browser's console show?
  var text = 'outside';
function logIt(){
    console.log(text);
    var text = 'inside';
};
logIt();
*/
/*
Problem 18:
We're building a web game where everybody wins and we are all friends forever.
It's simple—you click on one of three boxes to see what nice thing you've won. You always win something nice. Because we love you.

Here's what we have so far. Something's going wrong though. Can you tell what it is?

  <button id="btn-0">Button 1!</button>
<button id="btn-1">Button 2!</button>
<button id="btn-2">Button 3!</button>

<script type="text/javascript">
    var prizes = ['A Unicorn!', 'A Hug!', 'Fresh Laundry!'];
    for (var btnNum = 0; btnNum < prizes.length; btnNum++) {
        // for each of our buttons, when the user clicks it...
        document.getElementById('btn-' + btnNum).onclick = function() {
            // tell her what she's won!
            alert(prizes[btnNum]);
        };
    }
</script>
The syntax is just fine—the problem is some unexpected behavior.
*/
/*
Problem 19:
Implement a queue ↴ with 2 stacks ↴ . Your queue should have an enqueue and a dequeue function and it should be "first in first out" (FIFO).
Optimize for the time cost of mm function calls on your queue. These can be any mix of enqueue and dequeue calls.

Assume you already have a stack implementation and it gives O(1)O(1) time push and pop.
*/
/*
Problem 20:
You want to be able to access the largest element in a stack.
Use the built-in Stack class to implement a new class MaxStack with a function getMax() that returns the largest element in the stack. getMax() should not remove the item.

Your stacks will contain only integers.
*/
/*
Problem 21:
Your company delivers breakfast via autonomous quadcopter drones. And something mysterious has happened.
Each breakfast delivery is assigned a unique ID, a positive integer. When one of the company's 100 drones takes off with a delivery, the delivery's ID is added to an array, deliveryIdConfirmations. When the drone comes back and lands, the ID is again added to the same array.

After breakfast this morning there were only 99 drones on the tarmac. One of the drones never made it back from a delivery. We suspect a secret agent from Amazon placed an order and stole one of our patented drones. To track them down, we need to find their delivery ID.

Given the array of IDs, which contains many duplicate integers and one unique integer, find the unique integer.

The IDs are not guaranteed to be sorted or sequential. Orders aren't always fulfilled in the order they were received, and some deliveries get cancelled before takeoff.
*/
/*
Problem 22:
Delete a node from a singly-linked list ↴ , given only a variable pointing to that node.
The input could, for example, be the variable b below:

  public static class LinkedListNode {

    public String value;
    public LinkedListNode next;

    public LinkedListNode(String value) {
        this.value = value;
    }
}

LinkedListNode a = new LinkedListNode("A");
LinkedListNode b = new LinkedListNode("B");
LinkedListNode c = new LinkedListNode("C");

a.next = b;
b.next = c;

deleteNode(b);
*/
/*
Problem 23:
You have a singly-linked list ↴ and want to check if it contains a cycle.
A singly-linked list is built with nodes, where each node has:

node.next—the next node in the list.
node.data—the data held in the node. For example, if our linked list stores people in line at the movies, node.data might be the person's name.
For example:

  public static class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }
}

A cycle occurs when a node’s next points back to a previous node in the list. The linked list is no longer linear with a beginning and end—instead, it cycles through a loop of nodes.

Write a function containsCycle() that takes the first node in a singly-linked list and returns a boolean indicating whether the list contains a cycle.
*/
/*
Problem 24:
Hooray! It's opposite day. Linked lists go the opposite way today.
Write a function for reversing a linked list ↴ . Do it in-place ↴ .

Your function will have one input: the head of the list.

Your function should return the new head of the list.

Here's a sample linked list node class:

  public static class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }
}
*/
/*
Problem 25:
You have a linked list ↴ and want to find the kkth to last node.
Write a function kthToLastNode() that takes an integer kk and the headNode of a singly linked list, and returns the kkth to last node in the list.

For example:

  public static class LinkedListNode {

    public String value;
    public LinkedListNode next;

    public LinkedListNode(String value) {
        this.value = value;
    }
}

LinkedListNode a = new LinkedListNode("Angel Food");
LinkedListNode b = new LinkedListNode("Bundt");
LinkedListNode c = new LinkedListNode("Cheese");
LinkedListNode d = new LinkedListNode("Devil's Food");
LinkedListNode e = new LinkedListNode("Eccles");

a.next = b;
b.next = c;
c.next = d;
d.next = e;

kthToLastNode(2, a);
// returns the node with value "Devil's Food" (the 2nd to last node)
*/
/*
Problem 26:
Write a function to reverse a string in-place ↴ .
Since strings in Java are immutable ↴ , first convert the string into an array of characters, do the in-place reversal on that array, and convert that array into a string before returning it. This isn't technically "in-place," and the array of characters will cost O(n)O(n) additional space, so if you're comfortable coding in a language with mutable strings, that'd be even better!
*/
/*
Problem 27:
You're working on a secret team solving coded transmissions.
Your team is scrambling to decipher a recent message, worried it's a plot to break into a major European National Cake Vault. The message has been mostly deciphered, but all the words are backwards! Your colleagues have handed off the last step to you.

Write a function reverseWords() that takes a string message and reverses the order of the words in-place ↴ .

Since strings in Java are immutable ↴ , we'll first convert the string into an array of characters, do the in-place word reversal on that array, and re-join that array into a string before returning it. But keep in mind that this isn't technically "in-place," and the array of characters will cost O(n)O(n) additional space! If you're comfortable coding in a language with mutable strings, that'd be even better!

For example:

  String message = "find you will pain only go you recordings security the into if";

reverseWords(message);
// returns: "if into the security recordings you go only pain will you find"

When writing your function, assume the message contains only letters and spaces, and all words are separated by one space.
*/
/*
Problem 28:
I like parentheticals (a lot).
"Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing."

Write a function that, given a sentence like the one above, along with the position of an opening parenthesis, finds the corresponding closing parenthesis.

Example: if the example string above is input with the number 10 (position of the first parenthesis), the output should be 79 (position of the last parenthesis).
*/
/*
Problem 29:
You're working with an intern that keeps coming to you with JavaScript code that won't run because the braces, brackets, and parentheses are off. To save you both some time, you decide to write a braces/brackets/parentheses validator.
Let's say:

'(', '{', '[' are called "openers."
')', '}', ']' are called "closers."
Write an efficient function that tells us whether or not an input string's openers and closers are properly nested.

Examples:

"{ [ ] ( ) }" should return true
"{ [ ( ] ) }" should return false
"{ [ }" should return false
*/
/*
Problem 30:
Write an efficient function that checks whether any permutation ↴ of an input string is a palindrome ↴ .
Examples:

"civic" should return true
"ivicc" should return true
"civil" should return false
"livci" should return false
*/
/*
Problem 31:
Write a recursive function for generating all permutations of an input string. Return them as a set.
Don't worry about time or space complexity—if we wanted efficiency we'd write an iterative version.

To start, assume ever character in the input string is unique.

Your function can have loops—it just needs to also be recursive.
*/
/*
Problem 32:
You created a game that is more popular than Angry Birds.
You rank players in the game from highest to lowest score. So far you're using an algorithm that sorts in O(n\lg{n})O(nlgn) time, but players are complaining that their rankings aren't updated fast enough. You need a faster sorting algorithm.

Write a function that takes:

an array of unsortedScores
the highestPossibleScore in the game
and returns a sorted array of scores in less than O(n\lg{n})O(nlgn) time.
*/
/*
Problem 33:
I have an array where every number in the range 1...n1...n appears once except for one number which appears twice.
Write a function for finding the number that appears twice.
*/
/*
Problem 34:
You want to build a word cloud, an infographic where the size of a word corresponds to how often it appears in the body of text.
To do this, you'll need data. Write code that takes a long string and builds its word cloud data in a hash map ↴ , where the keys are words and the values are the number of times the words occured.

Think about capitalized words. For example, look at these sentences:

  "After beating the eggs, Dana read the next step:"
"Add milk and eggs, then add flour and sugar."
What do we want to do with "After", "Dana", and "add"? In this example, your final hash map should include one "Add" or "add" with a value of 22. Make reasonable (not necessarily perfect) decisions about cases like "After" and "Dana".

Assume the input will only contain words and standard punctuation.
*/
/*
Problem 35:
Write a function for doing an in-place ↴ shuffle of an array.
The shuffle must be "uniform," meaning each item in the original array must have the same probability of ending up in each spot in the final array.

Assume that you have a function getRandom(floor, ceiling) for getting a random integer that is >=floor and <=ceiling.
*/
/*
Problem 36:
I figured out how to get rich: online poker.
I suspect the online poker game I'm playing shuffles cards by doing a single " riffle ↴ ."

To prove this, let's write a function to tell us if a full deck of cards shuffledDeck is a single riffle of two other halves half1 and half2.

We'll represent a stack of cards as an array of integers in the range 1..521..52 (since there are 5252 distinct cards in a deck).

Why do I care? A single riffle is not a completely random shuffle. If I'm right, I can make more informed bets and get rich and finally prove to my ex that I am not a "loser with an unhealthy cake obsession" (even though it's too late now because she let me go and she's never getting me back).

Solution
We walk through shuffledDeck, seeing if each card so far could have come from a riffle of the other two halves. To check this, we:

Keep pointers to the current index in half1, half2, and shuffledDeck.
Walk through shuffledDeck from beginning to end.
If the current card in shuffledDeck is the same as the top card from half1, increment half1Index and keep going. This can be thought of as "throwing out" the top cards of half1 and shuffledDeck, reducing the problem to the remaining cards in the stacks.
Same as above with half2.
If the current card isn't the same as the card at the top of half1 or half2, we know we don't have a single riffle.
If we make it all the way to the end of shuffledDeck and each card checks out, we know we do have a single riffle.

*/

  public boolean isSingleRiffle(int[] half1, int[] half2, int[] shuffledDeck) {
        int half1Index = 0;
        int half2Index = 0;
        int half1MaxIndex = half1.length - 1;
        int half2MaxIndex = half2.length - 1;

        for (int card : shuffledDeck) {
            // if we still have cards in half1
            // and the "top" card in half1 is the same
            // as the top card in shuffledDeck
            if (half1Index <= half1MaxIndex &&
                card == half1[half1Index]) {
                half1Index += 1;

            // if we still have cards in half2
            // and the "top" card in half2 is the same
            // as the top card in shuffledDeck
            } else if (half2Index <= half2MaxIndex &&
                card == half2[half2Index]) {
                half2Index += 1;

            // if the top card in shuffledDeck doesn't match the top
            // card in half1 or half2, this isn't a single riffle.
            } else {
                return false;
            }
        }

        // all cards in shuffledDeck have been "accounted for"
        // so this is a single riffle!
        return true;
    }
/*
Problem 37:
You have a function rand7() that generates a random integer from 1 to 7. Use it to write a function rand5() that generates a random integer from 1 to 5.
rand7() returns each integer with equal probability. rand5() must also return each integer with equal probability.
*/
/*
Problem 38:
You have a function rand5() that generates a random integer from 1 to 5. Use it to write a function rand7() that generates a random integer from 1 to 7.
rand5() returns each integer with equal probability. rand7() must also return each integer with equal probability.
*/
/*
Problem 39:
A building has 100 floors. One of the floors is the highest floor an egg can be dropped from without breaking.
If an egg is dropped from above that floor, it will break. If it is dropped from that floor or below, it will be completely undamaged and you can drop the egg again.

Given two eggs, find the highest floor an egg can be dropped from without breaking, with as few drops as possible.
*/
/*
Problem 40:
Find a duplicate, Space Edition™.
We have an array of integers, where:

The integers are in the range 1..n1..n
The array has a length of n+1n+1
It follows that our array has at least one integer which appears at least twice. But it may have several duplicates, and each duplicate may appear more than twice.

Write a function which finds any integer that appears more than once in our array.

We're going to run this function on our new, super-hip Macbook Pro With Retina Display™. Thing is, the damn thing came with the RAM soldered right to the motherboard, so we can't upgrade our RAM. So we need to optimize for space!
*/
/*
Problem 41:
Find a duplicate, Space Edition™ BEAST MODE
In Find a duplicate, Space Edition™, we were given an array of integers where:

the integers are in the range 1..n1..n
the array has a length of n+1n+1
These properties mean the array must have at least 1 duplicate. Our challenge was to find a duplicate number, while optimizing for space. We used a divide and conquer approach, iteratively cutting the array in half to find a duplicate integer in O(n\lg{n})O(nlgn) time and O(1)O(1) space (sort of a modified binary search).

But we can actually do better. We can find a duplicate integer in O(n)O(n) time while keeping our space cost at O(1)O(1).

This is a tricky one to derive (unless you have a strong background in graph theory), so we'll get you started:

Imagine each item in the array as a node in a linked list. In any linked list ↴ , each node has a value and a "next" pointer. In this case:

The value is the integer from the array.
The "next" pointer points to the value-eth node in the list (numbered starting from 1). For example, if our value was 3, the "next" node would be the third node.
Here’s a full example:
https://www.interviewcake.com/question/java/find-duplicate-optimize-for-space-beast-mode
Notice we're using "positions" and not "indices." For this problem, we'll use the word "position" to mean something like "index," but different: indices start at 0, while positions start at 1. More rigorously: position = index + 1.

Using this, find a duplicate integer in O(n)O(n) time while keeping our space cost at O(1)O(1).

Drawing pictures will help a lot with this one. Grab some paper and pencil (or a whiteboard, if you have one).
*/
/*
Problem 42:
You left your computer unlocked and your friend decided to troll you by copying a lot of your files to random spots all over your file system.
Even worse, she saved the duplicate files with random, embarrassing names ("this_is_like_a_digital_wedgie.txt" was clever, I'll give her that).

Write a function that returns a list of all the duplicate files. We'll check them by hand before actually deleting them, since programmatically deleting files is really scary. To help us confirm that two files are actually duplicates, return a list of FilePaths objects with variables for the original and duplicate paths:

  public class FilePaths {

    Path duplicatePath;
    Path originalPath;

    public FilePaths(Path duplicatePath, Path originalPath) {
        this.duplicatePath = duplicatePath;
        this.originalPath  = originalPath;
    }

    public String toString() {
        return "(original: " + originalPath + ", duplicate: " + duplicatePath + ")";
    }
}
For example:

[(original: /tmp/parker_is_dumb.mpg, duplicate: /home/parker/secret_puppy_dance.mpg),
(original: /home/trololol.mov, duplicate: /etc/apache2/httpd.conf)]
You can assume each file was only duplicated once.
*/
/*
Problem 43:
In order to win the prize for most cookies sold, my friend Alice and I are going to merge our Girl Scout Cookies orders and enter as one unit.
Each order is represented by an "order id" (an integer).

We have our lists of orders sorted numerically already, in arrays. Write a function to merge our arrays of orders into one sorted array.

For example:
int[] myArray     = new int[]{3, 4, 6, 10, 11, 15};
int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};

System.out.println(mergeArrays(myArray, alicesArray));
// prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]
*/

}