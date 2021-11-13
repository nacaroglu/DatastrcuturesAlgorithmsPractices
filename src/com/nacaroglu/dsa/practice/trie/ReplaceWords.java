package com.nacaroglu.dsa.practice.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ReplaceWords {

	public static class TrieNode {

		Character chr;
		boolean isEnd;		
		TrieNode left;
		TrieNode middle;
		TrieNode right;
		StringBuffer sb;

		public TrieNode(Character chr) {
			super();
			this.chr = chr;			
		}

		@Override
		public String toString() {
			return "TrieNode [char=" + chr + ", isEnd=" + isEnd + "]";
		}
	}

	public static void main(String[] args) {

		ReplaceWords r = new ReplaceWords();
		
		List<String> dictionary = new ArrayList<String>();
		
		/*
		dictionary.add("cat");
		dictionary.add("bat");
		dictionary.add("rat");		
		String result = r.replaceWords(dictionary, "the cattle was rattled by the battery");
		System.out.println(result);
		
		dictionary.clear();
		
		dictionary.add("a");
		dictionary.add("b");
		dictionary.add("c");
		
		r.root = new TrieNode(null);
		result = r.replaceWords(dictionary, "aadsfasf absbs bbab cadsfafs");
		System.out.println(result);
		
		
		dictionary.clear();
		
		dictionary.add("ac");
		dictionary.add("ab");		
		
		r.root = new TrieNode(null);
		result = r.replaceWords(dictionary, "it is abnormal that this solution is accepted");
		System.out.println(result);*/
		
		String[] arr = { "e", "k", "c", "harqp", "h", "gsafc", "vn", "lqp", "soy", "mr", "x", "iitgm", "sb", "oo",
				"spj", "gwmly", "iu", "z", "f", "ha", "vds", "v", "vpx", "fir", "t", "xo", "apifm", "tlznm", "kkv",
				"nxyud", "j", "qp", "omn", "zoxp", "mutu", "i", "nxth", "dwuer", "sadl", "pv", "w", "mding", "mubem",
				"xsmwc", "vl", "farov", "twfmq", "ljhmr", "q", "bbzs", "kd", "kwc", "a", "buq", "sm", "yi", "nypa",
				"xwz", "si", "amqx", "iy", "eb", "qvgt", "twy", "rf", "dc", "utt", "mxjfu", "hm", "trz", "lzh", "lref",
				"qbx", "fmemr", "gil", "go", "qggh", "uud", "trnhf", "gels", "dfdq", "qzkx", "qxw" };
		String sentence = "ikkbp miszkays wqjferqoxjwvbieyk gvcfldkiavww vhokchxz dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dco kddxmckhvqifbuzkhstp wc ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy ifvifheoxqlbosfww mengfdydekwttkhbzenk wjhmmyltmeufqvcpcxg hthcuovils ldipovluo aiprogn nusquzpmnogtjkklfhta klxvvlvyh nxzgnrveghc mpppfhzjkbucv cqcft uwmahhqradjtf iaaasabqqzmbcig zcpvpyypsmodtoiif qjuiqtfhzcpnmtk yzfragcextvx ivnvgkaqs iplazv jurtsyh gzixfeugj rnukjgtjpim hscyhgoru aledyrmzwhsz xbahcwfwm hzd ygelddphxnbh rvjxtlqfnlmwdoezh zawfkko iwhkcddxgpqtdrjrcv bbfj mhs nenrqfkbf spfpazr wrkjiwyf cw dtd cqibzmuuhukwylrnld dtaxhddidfwqs bgnnoxgyynol hg dijhrrpnwjlju muzzrrsypzgwvblf zbugltrnyzbg hktdviastoireyiqf qvufxgcixvhrjqtna ipfzhuvgo daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh qzsaobsghgm ichlpsjlsrwzhbyfhm ksenb bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala qmxixtooxtbrzyorn gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn frotscysdyclrc ckcttaceuuxzcghw pxbd oklwhcppuziixpvihihp";
		
		
		
		
		for (String string : arr) {
			dictionary.add(string);
		}
		
		String result = r.replaceWords(dictionary, sentence);
		System.out.println(result);
	}

	TrieNode root;

	public ReplaceWords() {

		root = new TrieNode(null);
	}
	
	public void insert(String word) {
		root.middle = insert_helper(root.middle, word, 0, new StringBuffer());
	}

	private TrieNode insert_helper(TrieNode node, String word, int depth, StringBuffer sb) {

		char c = word.charAt(depth);

		if (node == null) {
			node = new TrieNode(c);
			node.sb = new StringBuffer(sb.toString());
			node.sb.append(c);
		}		

		if (c < node.chr) {
			node.left = insert_helper(node.left, word, depth, sb);
		} else if (c > node.chr) {
			node.right = insert_helper(node.right, word, depth,sb);
		} else if (depth < word.length() - 1) {
			node.middle = insert_helper(node.middle, word, depth + 1, node.sb);
		} else {			
			node.isEnd = true;			
		}

		return node;
	}	
	public String replaceWords(List<String> dictionary, String sentence) {
		
		reArrangeDictonary(dictionary);
		
		String[] arr = sentence.split(" ");
		
		for (String w : arr) {
			insert(w);
		}
		
		TrieNode curr;
		
		for(String s : dictionary) {			
			
			int depth = 0;
			curr = this.root.middle;
			curr = containsPrefix(curr, s, depth);		
			if(curr==null) {
				continue;
			}
			List<String> mathchList = new ArrayList<String>();
			replaceWordsHelper(curr.middle, mathchList);			
			replaceWithMatches(arr, s, mathchList);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]);
			
			if(i<arr.length-1) {
				sb.append(" ");
			}
		}

		return sb.toString();
	}

	private TrieNode containsPrefix(TrieNode curr, String s, int depth) {
		while (curr != null) {

			char chr = curr.chr;

			if (s.charAt(depth) < chr) {
				curr = curr.left;
			} else if (s.charAt(depth) > chr) {
				curr = curr.right;
			} else if (depth < s.length() - 1) {
				curr = curr.middle;
				depth++;
			} else {
				break;
			}
		}
		return curr;
	}

	private void replaceWithMatches(String[] arr, String s, List<String> mathchList) {
		for (String match : mathchList) {
			for(int i=0; i<arr.length; i++) {
				if(arr[i].equals(match)) {
					arr[i] = s; 
				}
			}
		}
	}
	
	private void replaceWordsHelper(TrieNode curr, List<String> mathchList) {
		
		if(curr==null) {			
			return;
		}
		
		if(curr.isEnd) {
			mathchList.add(curr.sb.toString());
		}
		
		replaceWordsHelper(curr.left, mathchList);
		replaceWordsHelper(curr.right, mathchList);
		replaceWordsHelper(curr.middle, mathchList);	 
	}

	private void reArrangeDictonary(List<String> dictionary) {
		PriorityQueue<String> q = new PriorityQueue<>(dictionary.size(),
				(node1, node2) -> node1.length() - node2.length());
		
		for (String s : dictionary) {
			q.add(s);
		}
		
		dictionary.clear();
		while(!q.isEmpty()) {
			dictionary.add(q.poll());
		}
	}


}
