package com.ames.provatecnica.repositories;

import com.ames.provatecnica.models.DesktopModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesktopRepository extends JpaRepository<DesktopModel, Long> {
    // Aquí puedes agregar métodos personalizados para consultas o operaciones específicas de desktops
}