package com.meihua.repository;

import com.meihua.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File,String> {
}
