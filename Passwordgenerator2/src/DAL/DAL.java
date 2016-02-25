package DAL;
import java.util.List;

import user.OperatorDTO;

public class DAL implements iOperatorDAO {
	private final Storage s = new Storage();
	
	@Override
	public OperatorDTO getOperator(int oprId) throws DALException {
		return s.getData(oprId);
	}
	@Override
	public List<OperatorDTO> getOperatorList() throws DALException {
		return s.getData();
	}

	@Override
	public void createOperator(OperatorDTO opr) throws DALException {
		s.addData(opr);
	}

	@Override
	public void updateOperator(OperatorDTO opr) throws DALException {
		s.updateData(opr);
	}

	@Override
	public void deleteOperator(OperatorDTO opr) throws DALException {
		s.deleteData(opr);
	}

}
