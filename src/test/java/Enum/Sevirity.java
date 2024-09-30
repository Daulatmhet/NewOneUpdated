package Enum;

public enum Sevirity {
	
	
	CRITICAL(2), MEDIUM(4) , HIGH(6) , LOW(8);
	
	private int fixinghours;
	
	
	public int getFixinghours() {
		return fixinghours;
	}


	public void setFixinghours(int fixinghours) {
		this.fixinghours = fixinghours;
	}


	private Sevirity(int hours)
	{
		fixinghours = hours;
	}
	
}





	
	
	
//	CRITICAL {
//		@Override
//		public String asLowerCase() {
//			return Sevirity.CRITICAL.toString().toLowerCase();
//		}
//	},
//	HIGH {
//		@Override
//		public String asLowerCase() {
//
//			return Sevirity.HIGH.toString().toLowerCase();
//
//		}
//	},
//	MEDIUM {
//		@Override
//		public String asLowerCase() {
//			return Sevirity.MEDIUM.toString().toLowerCase();
//			
//		}
//	},
//	LOW {
//		@Override
//		public String asLowerCase() {
//			return Sevirity.LOW.toString().toLowerCase();
//
//		}
//	};
//	
//	 public abstract String asLowerCase();
//	 
//		 
//	 
//
//}
