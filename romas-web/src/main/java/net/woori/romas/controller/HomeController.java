package net.woori.romas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.woori.romas.domain.DashboardInfo;
import net.woori.romas.domain.chart.ChartInfo;
import net.woori.romas.service.common.ChartService;
import net.woori.romas.service.common.DashboardService;

/**
 * 가뭄단계현황 화면
 * 
 * @author hgko
 *
 */
@Controller
public class HomeController {
	
	@Autowired
	private ChartService chartService;
	
	@Autowired
	private DashboardService dashboardService;

	@GetMapping("/")
	public String index() {
		return "redirect:home";
	}
	
	@GetMapping("/home")
	public void home(Model model) {
		model.addAttribute("view", "home");
	}
	
	@GetMapping("/home/chart")
	@ResponseBody
	public ChartInfo chart() {
		return chartService.createBarChartInfo();
	}
	
	@GetMapping("/home/dashboard")
	@ResponseBody
	public DashboardInfo dashboard(String name) {
		return dashboardService.createDashboardInfo(name);
	}
}
