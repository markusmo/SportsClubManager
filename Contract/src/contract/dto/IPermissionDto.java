/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto;

/**

 @author Thomas
 */
public interface IPermissionDto
        extends IDto
{
    String getDescription();

    String getName();

    void setDescription(String description);

    void setName(String name);
}
