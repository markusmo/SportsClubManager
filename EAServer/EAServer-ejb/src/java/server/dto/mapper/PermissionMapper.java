/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.CouldNotDeleteException;
import contract.domain.CouldNotFetchException;
import contract.domain.CouldNotSaveException;
import contract.dto.IPermissionDto;
import contract.dto.classes.PermissionDto;
import contract.dto.mapper.IMapper;
import contract.dto.mapper.IdNotFoundException;
import contract.dto.mapper.NotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.domain.DomainFacade;

/**

 @author Thomas
 */
public class PermissionMapper
        implements IMapper<IPermissionDto>
{
    private static PermissionMapper controller;

    PermissionMapper()
    {
    }

    public static IMapper<IPermissionDto> getInstance()
    {
        if (controller == null)
        {
            controller = new PermissionMapper();
        }

        return controller;
    }

    public contract.domain.IPermission getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IPermission a = DomainFacade.getInstance().getByID(contract.domain.IPermission.class, id);
            return a;
        }
        catch (Exception ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public IPermissionDto getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IPermission a = DomainFacade.getInstance().getByID(contract.domain.IPermission.class, id);
            return PermissionDto.copy(a);
        }
        catch (Exception ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public List<IPermissionDto> getAll()
            throws NotFoundException
    {
        try
        {
            List<IPermissionDto> result = new LinkedList<IPermissionDto>();

            for (contract.domain.IPermission a : DomainFacade.getInstance().getAll(contract.domain.IPermission.class))
            {
                result.add(PermissionDto.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(IPermissionDto value)
    {
        try
        {
            server.domain.classes.Permission permission = createDomain(value);

            return DomainFacade.getInstance().set(permission);
        } catch (CouldNotSaveException ex)
        {
            Logger.getLogger(PermissionMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(PermissionMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(IPermissionDto value)
    {
        try
        {
            server.domain.classes.Permission permission = createDomain(value);

            DomainFacade.getInstance().delete(permission);
        } catch (CouldNotDeleteException ex)
        {
            Logger.getLogger(PermissionMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(PermissionMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private server.domain.classes.Permission createDomain(IPermissionDto value)
            throws IdNotFoundException
    {
        server.domain.classes.Permission permission = new server.domain.classes.Permission(value.getId());

        permission.setDescription(value.getDescription());
        permission.setName(value.getName());

        return permission;
    }

    @Override
    public IPermissionDto getNew()
    {
        return new PermissionDto();
    }
}
