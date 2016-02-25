package DAL;

import java.util.ArrayList;
import java.util.List;

import user.OperatorDTO;

public class Storage {
	List<OperatorDTO> pepsData = new ArrayList<>();
	{
		pepsData.add(new OperatorDTO("sysAdmin", 0000000001, 11));
	}
	public Storage(){
		
	}
	public OperatorDTO getData(int oprId){
		for (OperatorDTO O : pepsData){
			if(O.getOprId() == oprId){
				return O;
			}
		} return null;
	}
	
	public List<OperatorDTO> getData(){
		return pepsData;
	}
	
	public void addData(OperatorDTO opr){
		pepsData.add(opr);
	}
	public void updateData(OperatorDTO opr){
		for(OperatorDTO Op : pepsData){
			if(Op.equals(opr)){
				pepsData.set(pepsData.indexOf(Op), opr);
				break;
			}
		}
	}
	public void deleteData(OperatorDTO opr){
			List<OperatorDTO> tmp = pepsData;
			for (OperatorDTO Op : tmp){
				if(Op.equals(opr)){
					pepsData.remove(tmp.indexOf(Op));
					break;
				}
			}
	}
}
