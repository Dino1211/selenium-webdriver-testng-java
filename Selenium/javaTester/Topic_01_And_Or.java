package javaTester;

public class Topic_01_And_Or {

	public static void main(String[] args) {
		// có 2 điều kiện
		// Kết hợp and hoặc or giữa 2 điều kiện này 
		// Ra kết quả
		boolean firstCondition;
		boolean secondCondition;
		boolean result;
		
		//AND: Nếu 1 trong 2 điều kiện mà sai = sai
		// Chỉ khi nào cả 2 đều đúng = đúng
		// ĐK 1 =    True	False	False	True
		// ĐK 2 =    False	True	False	True
		// Result =  False	False 	False 	True
		
		firstCondition = true;
		secondCondition = false;
		System.out.println(firstCondition && secondCondition);
		
		//OR: Nếu 1 trong 2 điều kiện mà đúng = đúng
		// ĐK 1 =    True	False	False	True
		// ĐK 2 =    False	True	False	True
		// Result =  True	True 	False 	True
		
		firstCondition = true;
		secondCondition = false;
		System.out.println(firstCondition || secondCondition);
		
	}

}
