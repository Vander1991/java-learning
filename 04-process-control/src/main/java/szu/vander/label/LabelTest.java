package szu.vander.label;

/**
 * @author : Vander
 * @date : 2018-11-01
 * @description ：Java中使用标签的唯一理由是因为有循环嵌套，而想从多层嵌套中break或continue
 */
public class LabelTest {

	public void test() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int sum = 0;
		label: 
		for (int i = 0; i < nums.length; i++) {
			for (int j = nums.length-1; j > 0; j--) {
				sum = nums[i] + nums[j];
				if(nums.length - j > 3) {
					break label;
				}
			}
		}
		System.out.println("sum = " + sum);
	}

}
