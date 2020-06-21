package week02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
   
}
