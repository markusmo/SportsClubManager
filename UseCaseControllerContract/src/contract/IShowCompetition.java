/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract;

import java.util.List;
import dto.contract.*;

/**
 *
 * @author Lucia
 */
public interface IShowCompetition {
    
    List<ICompetition> getCompetitions();
    List<IMatch> getMatchs(List<Integer> matches);
    List<ShowMatchObj> getTeams(List<Integer> matches);
    List<IPlayer> getPlayer(IClubTeam team);
    
    
}
