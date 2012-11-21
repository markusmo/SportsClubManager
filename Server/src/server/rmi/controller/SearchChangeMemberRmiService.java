/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi.controller;

import contract.dto.*;
import contract.rmi.services.ISearchChangeMemberRmiService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import server.useCaseController.SearchChangeMember;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class SearchChangeMemberRmiService
        extends UnicastRemoteObject
        implements ISearchChangeMemberRmiService
{
    public SearchChangeMemberRmiService()
            throws RemoteException
    {
        super();
    }

    @Override
    public List<IRole> getRoles(Integer memberId)
    {
        return SearchChangeMember.getInstance().getRoles(memberId);
    }

    @Override
    public IDepartment getDepartment(Integer memberId)
    {
        return SearchChangeMember.getInstance().getDepartment(memberId);
    }

    @Override
    public IAddress getAddress(Integer addressId)
    {
        return SearchChangeMember.getInstance().getAddress(addressId);
    }

    @Override
    public List<IDepartment> getDepartments()
    {
        return SearchChangeMember.getInstance().getDepartments();
    }

    @Override
    public List<IClubTeam> getClubTeams(List<Integer> clubTeams)
    {
        return SearchChangeMember.getInstance().getClubTeams(clubTeams);
    }

    @Override
    public void setNewMember(IMember member, IAddress address)
    {
        SearchChangeMember.getInstance().setNewMember(member, address);
    }

    @Override
    public void setNewMember(IMember member, IAddress address, IDepartment department, IClubTeam clubTeam, IRole role)
    {
        SearchChangeMember.getInstance().setNewMember(member, address, department, clubTeam, role);
    }

    @Override
    public IMember getMember(int searchMember)
            throws RemoteException
    {
        return SearchChangeMember.getInstance().getMember(searchMember);
    }

    @Override
    public List<IMember> getMatchingMembers(String searchInput)
    {
        return SearchChangeMember.getInstance().getMatchingMembers(searchInput);
    }

    @Override
    public ICountry getCountry(Integer countryID)
    {
        return SearchChangeMember.getInstance().getCountry(countryID);
    }

    @Override
    public List<ITypeOfSport> getTypeOfSports(List<Integer> sportsList)
            throws RemoteException
    {
        return SearchChangeMember.getInstance().getTypeOfSports(sportsList);
    }

    @Override
    public IMember getSelectedMember()
    {
        return SearchChangeMember.getInstance().getSelectedMember();
    }

    @Override
    public void setSelectedMember(IMember selectedMember)
    {
        SearchChangeMember.getInstance().setSelectedMember(selectedMember);
    }
}
