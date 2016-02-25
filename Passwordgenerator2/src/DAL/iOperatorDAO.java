package DAL;
import java.util.List;

import user.OperatorDTO;

public interface iOperatorDAO {
	OperatorDTO getOperator(int oprId) throws DALException;
	List<OperatorDTO> getOperatorList() throws DALException;
	void createOperator(OperatorDTO opr) throws DALException;
	void updateOperator(OperatorDTO opr) throws DALException;
	void deleteOperator(OperatorDTO opr) throws DALException;

}
