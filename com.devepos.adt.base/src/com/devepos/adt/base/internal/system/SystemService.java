package com.devepos.adt.base.internal.system;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;

import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.base.model.adtbase.IUser;
import com.devepos.adt.base.system.ISystemService;
import com.sap.adt.tools.core.AbapCore;
import com.sap.adt.tools.core.system.IAbapSystemInfo;

/**
 * Access to global ABAP system resources, like Users
 *
 * @author stockbal
 *
 */
@SuppressWarnings("restriction")
public class SystemService implements ISystemService {

    @Override
    public List<IUser> getUsers(final String destinationId) {
        if (destinationId == null) {
            return null;
        }
        final IAbapSystemInfo systemInfo = AbapCore.getInstance().getAbapSystemInfo(destinationId);
        List<IUser> users = new ArrayList<>();
        for (com.sap.adt.tools.core.system.IUser adtUser : systemInfo.getUsers(new NullProgressMonitor())) {
            IUser user = IAdtBaseFactory.eINSTANCE.createUser();
            user.setName(adtUser.getId());
            user.setText(adtUser.getText());
            users.add(user);
        }
        return users;
    }

}
