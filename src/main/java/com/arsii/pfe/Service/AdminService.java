package com.arsii.pfe.Service;
import  com.arsii.pfe.Dto.RequestAdmin;
import com.arsii.pfe.Dto.ResponseAdmin;
import  com.arsii.pfe.Entities.Admin;
import java.util.List;

public interface AdminService {
    List<ResponseAdmin> getAllAdmin();
    boolean deleteAdmin(Long id);
    void createAdmin(RequestAdmin adminRequest);
    Admin updateAdmin(Long id, RequestAdmin adminRequest);
    ResponseAdmin getAdminById(Long id);
}
