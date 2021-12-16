package com.fabrisio.bluestore.datamining;

import com.fabrisio.bluestore.datamining.dto.DashboardApplicationDto;
import com.fabrisio.bluestore.datamining.dto.DashboardCompanyDto;
import com.fabrisio.bluestore.datamining.dto.DashboardEmployeeDto;

public interface DashboardService {

    DashboardCompanyDto estatisticasDaCompany();
    DashboardEmployeeDto estatisticasDaEmployee();
    DashboardApplicationDto estatisticasDaAplicacao();

}
