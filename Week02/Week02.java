package week02;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class Week02 {
    /**
     * 
     * 功能描述: 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * @param s
     * @param t
     * @return boolean
     * @version 2.0.0
     * @author 18047722
     */
    public boolean isAnagram(String s, String t) {
        Map<String,Integer> smap = new HashMap<String,Integer>();
        for(int i=0;i<s.length();i++){
            String cur = s.substring(i, i+1);
            Integer num = smap.get(cur)==null? 0 : smap.get(cur);
            smap.put(cur, ++num);
        }
        for(int i=0;i<t.length();i++){
            String cur = t.substring(i, i+1);
            if(smap.get(cur)==null ){
                return false;
            }else {
               Integer num = smap.get(cur);
               if(num<=1){
                   smap.remove(cur);
               }else{
                   smap.put(cur, --num);
               }
            }
        }
        
        return smap.isEmpty();
    }
    
    /**
     * 功能描述:  两数之和
     * 
     * @param nums
     * @param target
     * @return int[]
     * @version 2.0.0
     * @author 18047722
     */
    public int[] twoSum(int[] nums, int target) {
        //储存全部值 value 为下标
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i<nums.length ; i++){
            map.put(nums[i], i);
        }
        //
        for(int i = 0; i<nums.length ; i++){
            int key = target-nums[i];
            if(map.containsKey(key) && map.get(key)!=i){
                return new int[]{i,map.get(key)};
            }
        }
        return null;
    }
    /**
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     * 功能描述: 
     * 谦虚遍历的顺序为
     * 1.root
     * 2.left
     * 3.right
     * 而N叉树则需要遍历其children节点
     * @param root
     * @return List<Integer>
     * @version 2.0.0
     * @author 18047722
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list =new ArrayList<Integer>();
        pre(root, list);
        return list;
    }
    public void pre(Node root , List<Integer> list) {
        if(root==null){
            return;
        }
        list.add(root.val);
        for(Node node: root.children){
            pre(node,list);
        }
    }
    /**
     * 功能描述: 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
     * 
     * @param root
     * @return List<List<Integer>>
     * @version 2.0.0
     * @author 18047722
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list =new  ArrayList<List<Integer>>();
        if(root == null){
           return list;
        }
        Queue<Node> qu = new ArrayDeque<Node>();
        qu.add(root);
        while(!qu.isEmpty()){
           int size = qu.size();
           List<Integer> fList = new ArrayList<Integer>();
           for(int i = 0;i<size;i++){
               Node node = qu.poll();
               fList.add(node.val);
               if(!(node.children==null ||node.children.size()==0)){
                   qu.addAll(node.children);
               }
           }
           list.add(fList);
        }
        return list;
    }
    /**
     * 
     * 功能描述: 49. 字母异位词分组
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * @param strs
     * @return List<List<String>>
     * @version 2.0.0
     * @author 18047722
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<List<String>>();
        if(strs ==null ||strs.length<1){
            return list;
            
        }
        //新建一个map 保存异位词  key为排序后的字符  value为一个list  每次向后面添加
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(String s :strs){
            char[] c = s.toCharArray();
            //排序
            Arrays.sort(c);
            //转换为字符串  这里千万不要用 toString
            String st =String.valueOf(c);
            List<String> arr = new ArrayList<String>();
            if(map.containsKey(st)){
                arr = map.get(st);
            }
            arr.add(s);
            map.put(st,arr);
        }
        if(!map.isEmpty()){
            for(String key:map.keySet()){//keySet获取map集合key的集合  然后在遍历key即可
                list.add(map.get(key));
            }
        }
        return list;
    }
    
    /**
     * 功能描述: 94. 二叉树的中序遍历
     * 
     * @param root
     * @return List<Integer>
     * @version 2.0.0
     * @author 18047722
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list =new ArrayList<Integer>();
        
        inorder(root,list);
        return list;
        
    }
    /**
     * 功能描述: 中序遍历
     * 1.左节点
     * 2.根节点
     * 3.右节点
     * 
     * @param root
     * @param list void
     * @version 2.0.0
     * @author 18047722
     */
    public void inorder(TreeNode root ,List<Integer> list) {
        if(root == null) return;
        if(root.left != null){
            inorder(root.left,list);
        }
        list.add(root.val);
        if(root.right != null){
            inorder(root.right,list);
        }
        
        
    }
    /**
     * 功能描述:  二叉树的前序遍历
     * 
     * @param root
     * @return List<Integer>
     * @version 2.0.0
     * @author 18047722
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list =new ArrayList<Integer>();
        
        preorder(root,list);
        return list;
    }
    /**
     * 功能描述: 前序遍历
     * 1.根节点
     * 2.左节点
     * 3.右节点
     * 
     * @param root
     * @param list void
     * @version 2.0.0
     * @author 18047722
     */
    public void preorder(TreeNode root ,List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        
        if(root.left != null){
            preorder(root.left,list);
        }
        
        if(root.right != null){
            preorder(root.right,list);
        }
        
        
    }
    /**
     * 功能描述: 剑指 Offer 49. 丑数
     * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     * 
     * 计算第n个抽数的方法类似于 斐波那契数列  但是又有一些不同的地方
     * 斐波那契数列 至于n-1  与 n-2 有管
     * 但是抽数不能确定n的值  因此只能从index为0开始计算
     * 第n个数的值 为三个指针指向的值乘以对应的因子最小的那个
     * @param n
     * @return int
     * @version 2.0.0
     * @author 18047722
     */
    public int nthUglyNumber(int n) {
        int a=0,b=0,c = 0;
        int[] in = new int[n];
        in[0]=1;
        for(int i=1;i<n;i++){
          int a2 = in[a]*2;
          int b3 = in[b]*3;
          int c5 = in[c]*5;
          int temp = Math.min(Math.min(a2, b3),c5);
          in[i] = temp;
          if(temp==a2){
              a++;
          }
          if(temp == b3){
              b++;
          }
          if(temp == c5){
              c++;
          }
        }
        
        
        
        return in[n-1];
    }
    /**
     * 功能描述: 347. 前 K 个高频元素
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     * 前k个的数组  首先想到的是堆  然后每次从中poll堆顶元素
     * @param nums
     * @param k
     * @return int[]
     * @version 2.0.0
     * @author 18047722
     */
    public int[] topKFrequent(int[] nums, int k) {
        //1.统计nums中每个数字的数量放入到map中
        Map<Integer,Integer> map =new HashMap<Integer,Integer>();
        for(int i :nums){
            int num = 1;
            if(map.containsKey(i)){
                num = map.get(i)+1;
            }
            map.put(i, num);
        }
        //2.将map中value大于等于k的key值放入的堆中
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));
        for(Integer key:map.keySet()){
            heap.add(key);
            if(heap.size()>k){
                heap.poll();
            }
        }
        k = heap.size();
        int[] result =new int[k];
        for(int i=k-1;i>=0;i--){
            result[i]=heap.poll();
        }
        
        return result;
    }
    
    
}
