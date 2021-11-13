package com.nacaroglu.dsa.practice.dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		
		/*
		
		System.out.println(lps.longestPalindrome("cbbd"));
		
		System.out.println(lps.longestPalindrome("bb"));
		
		System.out.println(lps.longestPalindrome("ahmettemhax"));
		System.out.println(lps.longestPalindrome("yahmettemha"));
		System.out.println(lps.longestPalindrome("abb"));
		
	
		
		System.out.println(lps.longestPalindrome("bbbb"));	
		
		System.out.println(lps.longestPalindrome("abaxyztzyxaba"));
		
		System.out.println(lps.longestPalindrome("asdfXXfdsa"));
		
		System.out.println(lps.longestPalindrome("ac"));
		
		
		
		System.out.println(lps.longestPalindrome("ccc"));
		
		
		System.out.println(lps.longestPalindrome("aaaaa"));		
		System.out.println(lps.longestPalindrome("aaaa"));			
			
		
		
		
		System.out.println(lps.longestPalindrome("ac"));
		
		System.out.println(lps.longestPalindrome("cbbd"));
		
		
		*/
		
		
		System.out.println(lps.longestPalindrome("jrjnbctoqgzimtoklkxcknwmhiztomaofwwzjnhrijwkgmwwuazcowskjhitejnvtblqyepxispasrgvgzqlvrmvhxusiqqzzibcyhpnruhrgbzsmlsuacwptmzxuewnjzmwxbdzqyvsjzxiecsnkdibudtvthzlizralpaowsbakzconeuwwpsqynaxqmgngzpovauxsqgypinywwtmekzhhlzaeatbzryreuttgwfqmmpeywtvpssznkwhzuqewuqtfuflttjcxrhwexvtxjihunpywerkktbvlsyomkxuwrqqmbmzjbfytdddnkasmdyukawrzrnhdmaefzltddipcrhuchvdcoegamlfifzistnplqabtazunlelslicrkuuhosoyduhootlwsbtxautewkvnvlbtixkmxhngidxecehslqjpcdrtlqswmyghmwlttjecvbueswsixoxmymcepbmuwtzanmvujmalyghzkvtoxynyusbpzpolaplsgrunpfgdbbtvtkahqmmlbxzcfznvhxsiytlsxmmtqiudyjlnbkzvtbqdsknsrknsykqzucevgmmcoanilsyyklpbxqosoquolvytefhvozwtwcrmbnyijbammlzrgalrymyfpysbqpjwzirsfknnyseiujadovngogvptphuyzkrwgjqwdhtvgxnmxuheofplizpxijfytfabx" ));
		
		System.out.println(lps.longestPalindrome("ukxidnpsdfwieixhjnannbmtppviyppjgbsludrzdleeiydzawnfmiiztsjqqqnthwinsqnrhfjxtklvbozkaeetmblqbxbugxycrlzizthtuwxlmgfjokhqjyukrftvfwikxlptydybmmzdhworzlaeztwsjyqnshggxdsjrzazphugckgykzhqkdrleaueuajjdpgagwtueoyybzanrvrgevolwssvqimgzpkxehnunycmlnetfaflhusauopyizbcpntywntadciopanyjoamoyexaxulzrktneytynmheigspgyhkelxgwplizyszcwdixzgxzgxiawstbnpjezxinyowmqsysazgwxpthloegxvezsxcvorzquzdtfcvckjpewowazuaynfpxsxrihsfswrmuvluwbdazmcealapulnahgdxxycizeqelesvshkgpavihywwlhdfopmmbwegibxhluantulnccqieyrbjjqtlgkpfezpxmlwpyohdyftzgbeoioquxpnrwrgzlhtlgyfwxtqcgkzcuuwagmlvgiwrhnredtulxudrmepbunyamssrfwyvgabbcfzzjayccvvwxzbfgeglqmuogqmhkjebehtwnmxotjwjszvrvpfpafwomlyqsgnysydfdlbbltlwugtapwgfnsiqxcnmdlrxoodkhaaaiioqglgeyuxqefdxbqbgbltrxcnihfwnzevvtkkvtejtecqyhqwjnnwfrzptzhdnmvsjnnsnixovnotugpzuymkjplctzqbfkdbeinvtgdpcbvzrmxdqthgorpaimpsaenmnyuyoqjqqrtcwiejutafyqmfauufwripmpcoknzyphratopyuadgsfrsrqkfwkdlvuzyepsiolpxkbijqw"));
		
		//kztakrekvefgchersuoiuatzlmwynzjhdqqftjcqmntoyckqfawikkdrnfgbwtdpbkymvwoumurjdzygyzsbmwzpcxcdmmpwzmeibligwiiqbecxwyxigikoewwrczkanwwqukszsbjukzumzladrvjefpegyicsgctdvldetuegxwihdtitqrdmygdrsweahfrepdcudvyvrggbkthztxwicyzazjyeztytwiyybqdsczozvtegodacdokczfmwqfmyuixbeeqluqcqwxpyrkpfcdosttzooykpvdykfxulttvvwnzftndvhsvpgrgdzsvfxdtzztdiswgwxzvbpsjlizlfrlgvlnwbjwbujafjaedivvgnbgwcdbzbdbprqrflfhahsvlcekeyqueyxjfetkxpapbeejoxwxlgepmxzowldsmqllpzeymakcshfzkvyykwljeltutdmrhxcbzizihzinywggzjctzasvefcxmhnusdvlderconvaisaetcdldeveeemhugipfzbhrwidcjpfrumshbdofchpgcsbkvaexfmenpsuodatxjavoszcitjewflejjmsuvyuyrkumednsfkbgvbqxfphfqeqozcnabmtedffvzwbgbzbfydiyaevoqtfmzxaujdydtjftapkpdhnbmrylcibzuqqynvnsihmyxdcrfftkuoymzoxpnashaderlosnkxbhamkkxfhwjsyehkmblhppbyspmcwuoguptliashefdklokjpggfiixozsrlwmeksmzdcvipgkwxwynzsvxnqtchgwwadqybkguscfyrbyxudzrxacoplmcqcsmkraimfwbauvytkxdnglwfuvehpxd
		
		System.out.println(lps.longestPalindrome
				("vmqjjfnxtyciixhceqyvibhdmivndvxyzzamcrtpywczjmvlodtqbpjayfchpisbiycczpgjdzezzprfyfwiujqbcubohvvyakxfmsyqkysbigwcslofikvurcbjxrccasvyflhwkzlrqowyijfxacvirmyuhtobbpadxvngydlyzudvnyrgnipnpztdyqledweguchivlwfctafeavejkqyxvfqsigjwodxoqeabnhfhuwzgqarehgmhgisqetrhuszoklbywqrtauvsinumhnrmfkbxffkijrbeefjmipocoeddjuemvqqjpzktxecolwzgpdseshzztnvljbntrbkealeemgkapikyleontpwmoltfwfnrtnxcwmvshepsahffekaemmeklzrpmjxjpwqhihkgvnqhysptomfeqsikvnyhnujcgokfddwsqjmqgsqwsggwhxyinfspgukkfowoxaxosmmogxephzhhy"));
		
		
		

	}
	
	public String longestPalindrome(String s) {

		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		if(s.length()==1) {
			return s;
		}	
		
		int max = 1;
		map.put(1, s.substring(0, 1));
							
		if(isPalindrome(s)) {
			return s;
		}	
		
		int left = 0;
		int right = s.length()-1;		
		int counter = 0;
		
		while(left<s.length()-1 && right>=0) {
			
			if(isPalindrome(s.substring(left, right))) {
				return s.substring(left, right);
			}
			
			if(isPalindrome(s.substring(left+1, right+1))) {
				return s.substring(left+1, right+1);
			}
			
			if(counter%2==0)
				left = left +1;
			else 
				right = right -1;	
			
			counter++;
		}		
	
		return map.get(max);
	}
	
	public String longestPalindrome0(String s) {

		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		if(s.length()==1) {
			return s;
		}	
		
		int max = 1;
		map.put(1, s.substring(0, 1));
		
		char[] sArr = s.toCharArray();
		
		//if(sArr.length%2==1){
						
			int size = findPalindromeOfSide(sArr, sArr.length/2, map);			
			if(size>0) {
				return map.get(size);
			}
			
			max = Math.max(max, size);
		//}
		
		int index = sArr.length /2;
		
		int left = index - 1;
		int right = index + 1;
		
		while(left>=0 && right <=sArr.length-1) {
			
			int size1 = findPalindromeOfSide(sArr, left, map);		
			
			if(size1>0) {
				return map.get(size1);
			}
			
			int size2 = findPalindromeOfSide(sArr, right, map);	
			
			if(size2>0) {
				return map.get(size2);
			}
			
			max = Math.max(size1, max);
			max = Math.max(size2, max);
			
			left = left -1;
			right = right +1;			
		}		
	
		return map.get(max);
	}

	private int findPalindromeOfSide(char[] sArr, int index, HashMap<Integer, String> map ) {
		String palindrome = findPalindrome(sArr, index);
		
		if(palindrome!= null && !palindrome.isEmpty()) {
			map.put(palindrome.length(), palindrome);
			return palindrome.length();
		}
		
		return 0;
	}
	
	private String findPalindrome(char[] sArr, int i) {
		
		char prev = sArr[i-1];
		char curr = sArr[i];
		
		if(i+1>=sArr.length) {
			if(curr==prev) {
				return String.valueOf(sArr);
			}
		}
		
		char next = sArr[i+1];
		
		int left = i-1;
		int right = i+1;
		
	
		if(curr==prev && curr!=next) { // P2
			right = i;
			left = i-1;	
		}
		
		if(curr==next && curr!=prev) { // P2
			right = i+1;
			left = i;	
		}
		
		while(right<=sArr.length-1 && left>=0) {
			
			if(sArr[left]!=sArr[right]) {
				return String.valueOf(sArr).substring(left+1,right);
			}
			
			left = left-1;
			right = right + 1;
		}		
		
		return String.valueOf(sArr).substring(left+1, right);
	}

	public String longestPalindrome1(String s) {

		HashSet<String> set = new HashSet<String>();
		
		if(s.length()==1) {
			return s;
		}		
		
		set.add(s.substring(0, 1));	
		String lastOne = s.substring(0, 1);

		for (int i = 0; i < s.length(); i++) {	
		
			for(int j=i; j< s.length();j++) {
										
				String subString = s.substring(i, j+1);
				
				if(subString.length()==1) {
					continue;
				}
				
				if(set.contains(subString)) {
					continue;
				}else {
					if(isPalindrome(subString)) {
						
						if(subString.length()>lastOne.length()) {
							lastOne = subString;
						}
						
						set.add(subString);
					}
				}			
			}
		}
		
		
		//Map<String, Integer> java8Approach = set.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(
		//		Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		
		//return (String)java8Approach.keySet().toArray()[java8Approach.values().size()-1];
		
		return lastOne;
	}
	
	public String longestPalindrome2(String s) {

		TreeMap<String, Integer> set = new TreeMap<String, Integer>();
		
		if(s.length()==1) {
			return s;
		}

		set.put(s.substring(0, 1), 1);	

		for (int i = 0; i < s.length(); i++) {	
		
			for(int j=i; j< s.length();j++) {
										
				String subString = s.substring(i, j+1);
				
				if(set.containsKey(subString)) {
					continue;
				}else {
					if(isPalindrome(subString)) {
						set.put(subString, subString.length());
					}
				}			
			}
		}
		
		
		Map<String, Integer> java8Approach = set.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(
				Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		
		return (String)java8Approach.keySet().toArray()[java8Approach.values().size()-1];	
	}
	
	
	
	

	public String longestPalindrome3(String s) {

		HashMap<String, Integer> set = new HashMap<String, Integer>();
		
		if(s.length()==1) {
			return s;
		}

		char[] arr = s.toCharArray();

		set.put(s.substring(0, 1), 1);
		boolean isDouble = false;

		for (int i = 0; i < s.length() - 1; i++) {		

			int left = i - 1;
			int right = -1;
			isDouble = false;
			
			if(arr[i] == arr[i + 1] ) {	//aa	
				
				if(i==0) {
					right = i + 2;
					set.put(s.substring(i, i + 2), 2);
					isDouble = true;
				}else if (i>0 && arr[i-1]!= arr[i]) {
					right = i + 2;
					set.put(s.substring(i, i + 2), 2);
					isDouble = true;
				}
				else {					//xy
					right = i + 1;
				}
			}
			else {					//xy
				right = i + 1;
			}
			
			
			
			while (left >= 0 && right <arr.length-1 ) {			
			
				String subStr = s.substring(left, right+1);				

				if (!set.containsKey(subStr)) {

					if (arr[left] != arr[right]) {
						break;
					} else {
						set.put(subStr, subStr.length());
					}
				}
				left = left - 1;
				right = right + 1;
			}

		}

		int max = -1;
		for (int i : set.values()) {
			if (i > max) {
				max = i;
			}
		}

		for (String str : set.keySet()) {
			if (str.length() == max) {
				return str;
			}
		}

		return null;
	}
	
	public boolean isPalindrome(String s) {
		
		if(s==null ) { return true; }	
		
		char sArr[] = s.substring(0, s.length()/2).toCharArray();
		char tArr[];
		
		if(s.length()%2==0) {
			tArr = s.substring(s.length()/2).toCharArray(); 
		}else {
			tArr = s.substring(s.length()/2+1).toCharArray();
		}
		
		 for(int i=0; i< sArr.length; i++) {
			 if(sArr[i]!= tArr[sArr.length-1-i]){
				 return false;
			 }
		 } 
		 
		 return true;	
    }
}
