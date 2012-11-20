/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import contract.*;
import dto.contract.ICompetition;
import dto.contract.IDepartment;
import dto.contract.IMember;
import dto.contract.ITeam;
import dto.mapper.DtoFactory;
import dto.mapper.contract.NotFoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author EnjoX
 */
public class NewCompetition implements INewCompetition{
    private static INewCompetition INSTANCE;
    
    public static INewCompetition getInstance() {
        if(INSTANCE == null)
        {
            INSTANCE = new NewCompetition();
        }
        return INSTANCE;
    }

    @Override
    public void setCompetition(ICompetition competition, IMember member) {
        /*try {
            Integer sportId = competition.getSport();
            try {
                List<IDepartment> departmentList = DtoFactory.getDepartmentMapper().getAll();
                
            } catch (NotFoundException ex) {
                Logger.getLogger(NewCompetition.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            DtoFactory.getCompetitionMapper().set(competition);
        } catch (RemoteException ex) {
            Logger.getLogger(NewCompetition.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    @Override
    public List<ITeam> getTeams() {
        try {
            return DtoFactory.getTeamMapper().getAll();
        } catch (RemoteException | NotFoundException ex) {
            Logger.getLogger(NewCompetition.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
