package com.example.test11.learn;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

import org.junit.jupiter.api.Test;
import org.springframework.lang.Nullable;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;


public class LearnTest {


    @Nullable
    @Test
    public void testLiKou(){

//        double waterVolumOld = getWaterVolumYWGtRadius();
//        System.out.println("yw 大于 半径 公式算的值" + waterVolumOld);
        double waterVolumOld2 = getWaterVolumYWLtRadius();
        System.out.println("yw 小于等于 半径 公式算的值" + waterVolumOld2);


    }

    private double getWaterVolumYWLtRadius() {
        double radiusSection = 1.2;
        double YW = 0;
        double waterChamberLength = 11;
        double waterRate = 0.87;

        double acosYW = Math.acos((radiusSection - YW) / radiusSection);
        double degrees = Math.toDegrees(acosYW) * 2;
        //扇形面积
        double sectorArea = Math.PI * Math.pow(radiusSection, 2) * degrees / 360;
        //三角形，扇形中没有水的部分的 面积
        double triangleArea = radiusSection * (radiusSection - YW) * Math.sin(acosYW);
        double waterVolumOld = (sectorArea - triangleArea) * waterChamberLength * waterRate;
        return waterVolumOld;
    }

    private double getWaterVolumYWGtRadius() {
        double radiusSection = 1.2;
        double YW = 0;
        double waterChamberLength = 11;
        double waterRate = 0.87;

        double E2 = (YW - radiusSection) / radiusSection;
        double acosYW = Math.acos(E2);
        double v = Math.toDegrees(acosYW);
        double degrees = v * 2;
        //扇形面积
        double sectorArea = Math.PI * Math.pow(radiusSection, 2) * degrees / 360;
        //三角形，扇形中没有水的部分的 面积
        double triangleArea = radiusSection * (YW - radiusSection) * Math.sin(acosYW);
        double notWaterArea = (sectorArea - triangleArea);
        double waterVolumOld = (Math.PI * Math.pow(radiusSection, 2) - notWaterArea) * waterChamberLength * waterRate;
        return waterVolumOld;
    }

    @Test
    public void testLiKou2(){
        double waterOld = 25.538290026813918;
        double waterVollum132 = 27.34701885983704;
        double codeValue = waterVollum132 - waterOld;
        System.out.println("codeValue 值为" + codeValue);
    }



    @Test
    public void testLiKou3(){




        Double firstFlowmeter2Value = 1378989.0;
        Double firstFlowmeter1Value = 5280.9;
        Double secondFlowmeter2Value = 1378899.0;
        Double secondFlowmeter1Value = 5276.1;

        //不知道是否乱序，算绝对值
        double flowmeter2ValueDis = Math.abs(secondFlowmeter2Value - firstFlowmeter2Value);
        double flowmeter1ValueDis = Math.abs(secondFlowmeter1Value - firstFlowmeter1Value);
        //时间间隔转换为小时
        String flowDateFirst = "2023-10-11 13:52:00";
        String flowDateSecond = "2023-10-11 11:52:00";
        LocalDateTime beginTime = DateUtil.str2LocalDateTime(flowDateFirst, DateUtil.PATTERN_0);
        LocalDateTime endTime = DateUtil.str2LocalDateTime(flowDateSecond, DateUtil.PATTERN_0);
        // 计算时间间隔
        Duration duration = Duration.between(beginTime, endTime);
        long minutes = Math.abs(duration.toMinutes());
        //每分钟有多少流量，-》 每小时有多少流量
        // 有多少个小时
        double flowmeter1ValuePerHour = (double) flowmeter1ValueDis / minutes * 60;
        double flowmeter2ValuePerHour = (double) flowmeter2ValueDis / minutes * 60;
        double stationOutVolumeHour = flowmeter1ValuePerHour + flowmeter2ValuePerHour;
        System.out.println(stationOutVolumeHour);

    }

    private Map<Integer,Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return null;
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {


        if (preorder_left > preorder_right){
            return null;
        }

        //前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        //在中序遍历中找到根节点,不能 遍历什么的，复杂度太高，如果长度过长，复杂度高，性能高。
        int  inorder_root = indexMap.get(preorder[preorder_root]);

        //先把根节点建出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        //得到左子树节点数目
        int size_left_subtree = inorder_root - inorder_left;


        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder,inorder,preorder_left+1,preorder_left+size_left_subtree,inorder_left,inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
         root.right = myBuildTree(preorder,inorder,preorder_left+size_left_subtree+1,preorder_right,inorder_root+1,inorder_right);
         return root;

    }


    @Test
    public void tesFactorySimple() throws NoSuchAlgorithmException, NoSuchPaddingException {
        DateFormat dateInstance = DateFormat.getDateInstance(2);
        String format = dateInstance.format(new Date());
        System.out.println(format);


        //获取 不同加密算法的密钥生成器
        KeyGenerator keyGen = KeyGenerator.getInstance("DESede");
        //创建密码器
        Cipher cp = Cipher.getInstance("DESede");
    }


    @Test
    public void test1(){
       int[] inorder =  {9,3,15,20,7};
       int[] postOrder =  {9,15,7,20,3};
        TreeNode treeNode = buildTree2(inorder, postOrder);
        System.out.println(treeNode);
    }



//    private Map<Integer,Integer> indexMap;
    public TreeNode buildTree2(int[] inorder, int[] postorder) {

        int n = inorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            //数字不重复， 数字为key, value为索引，
            indexMap.put(inorder[i],i);
        }
        return myBuildTree2(postorder,inorder,0,n-1,0,n-1);
    }

    private TreeNode myBuildTree2(int[] postorder, int[] inorder, int postorder_left, int postorder_right, int inorder_left, int inorder_right) {


        if (postorder_left > postorder_right || inorder_left > inorder_right){
            return null;
        }
        int root = postorder[postorder_right];
        //中序遍历 找到 根节点位置，因为不重复，所以可以直接找
        Integer rootIndex = indexMap.get(root);
        TreeNode nodeRoot = new TreeNode(root);
        int left_tree_num = rootIndex - inorder_left;

        nodeRoot.left = myBuildTree2(postorder,inorder,postorder_left,postorder_left+left_tree_num-1,inorder_left,rootIndex-1);
        nodeRoot.right = myBuildTree2(postorder,inorder,postorder_left+left_tree_num,postorder_right-1,rootIndex+1,inorder_right);

        return nodeRoot;
    }


    //返回结果
    ArrayList<List<Integer>> result = new ArrayList<>();

    //测试层序遍历
    @Test
    public void testLevelOrderBottom(){
//        TreeNode root = new TreeNode(3);       // 创建根节点，值为3
//        TreeNode leftChild = new TreeNode(2);  // 创建值为2的左子节点
//        TreeNode rightChild = new TreeNode(1); // 创建值为1的右子节点
//        TreeNode leftChildLeft = new TreeNode(4);     // 创建值为4的左子节点
//        TreeNode rightChildRight = new TreeNode(5);   // 创建值为5的右子节点
//        TreeNode leftChildLeftLeft = new TreeNode(6);  // 创建值为6的左子节点
//        TreeNode leftChildLeftLeftRight = new TreeNode(7);  // 创建值为7的右子节点
//
//        root.left = leftChild;             // 连接根节点和左子节点
//        root.right = rightChild;           // 连接根节点和右子节点
//        leftChild.left = leftChildLeft;    // 连接值为2的节点和值为4的左子节点
//        rightChild.right = rightChildRight; // 连接值为1的节点和值为5的右子节点
//        rightChildRight.left = leftChildLeftLeft;                // 连接值为4的节点和值为6的左子节点
//        leftChildLeftLeft.right = leftChildLeftLeftRight;      // 连接值为6的节点和值为7的右子节点
        levelOrderBottom(null);
        System.out.println(result);
    }


    /**
     *  根节点
     * @param root
     * @return
     */
    public void levelOrderBottom(TreeNode root) {

        //1.需要一个队列
        List<TreeNode> treeNodes = new ArrayList<>();
        if (root == null){
            return;
        }
        treeNodes.add(root);
        throughLayer(treeNodes);
    }

    private void throughLayer(List<TreeNode> treeNodes) {
        if (CollectionUtils.isEmpty(treeNodes)){
            return;
        }

        ArrayList<Integer> oneLayerNodeValues = new ArrayList<>();
        ArrayList<TreeNode> oneLayerNode = new ArrayList<>();
        for (TreeNode treeNode : treeNodes) {
            //1.加值
            oneLayerNodeValues.add(treeNode.val);
            //2.加下一层的节点
            TreeNode left = treeNode.left;
            TreeNode right = treeNode.right;
            if (left!=null){
                oneLayerNode.add(treeNode.left);
            }
            if (right!=null){
                oneLayerNode.add(treeNode.right);
            }
        }
        throughLayer(oneLayerNode);
        result.add(oneLayerNodeValues);
    }




}
