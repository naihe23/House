package house_sale.dao;

import house_sale.model.AdminPassword;

public interface AdminDao {
    AdminPassword get_admin_ByName(String Uname);
}
