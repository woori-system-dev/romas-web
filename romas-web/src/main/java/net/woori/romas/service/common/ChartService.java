package net.woori.romas.service.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.woori.romas.domain.chart.BarChartSeries;
import net.woori.romas.domain.chart.ChartInfo;
import net.woori.romas.domain.chart.LineChartSeries;
import net.woori.romas.domain.db.ReservoirOperation;
import net.woori.romas.domain.param.SearchParam;

/**
 * 차트 관리 서비스
 * 
 * @author hgko
 *
 */
@Service
public class ChartService {
	
	/**
	 * 저수율 차트 정보 생성
	 * @return
	 */
	public ChartInfo createBarChartInfo() {
		
		ChartInfo chartInfo = new ChartInfo();
		
		BarChartSeries barChartSeries = new BarChartSeries();
		barChartSeries.addDataItem(110);
		barChartSeries.addDataItem(75);
		barChartSeries.addDataItem(90);
		barChartSeries.addDataItem(70);
		barChartSeries.addDataItem(80);
		barChartSeries.addDataItem(105);
		barChartSeries.addDataItem(95);
		barChartSeries.addDataItem(100);
		barChartSeries.addDataItem(75);
		barChartSeries.addDataItem(100);
		barChartSeries.setYAxis(110);
		
		chartInfo.setBarChartSeries(barChartSeries);
		
		return chartInfo;
	}
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	public ChartInfo createLineChartInfo(SearchParam param) {
		
		ChartInfo chartInfo = new ChartInfo();
		
		String[] categories = {"1.10", "2.10", "3.10", "4.10", "5.10", "6.10", "7.10", "8.10", "9.10", "10.10", "11.10", "12.10"};
		for (String data : categories) {
			chartInfo.addCategory(data);
		}
		
		LineChartSeries lineChartSeries = new LineChartSeries("저수율");
		lineChartSeries.addDataItem(52);
		lineChartSeries.addDataItem(54);
		lineChartSeries.addDataItem(60);
		lineChartSeries.addDataItem(70);
		lineChartSeries.addDataItem(46);
		lineChartSeries.addDataItem(35);
		lineChartSeries.addDataItem(75);
		lineChartSeries.addDataItem(77);
		lineChartSeries.addDataItem(82);
		lineChartSeries.addDataItem(89);
		lineChartSeries.addDataItem(90);
		
		chartInfo.addLineChartSeries(lineChartSeries);
		
		return chartInfo;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<ReservoirOperation> createGoogleChartInfo() {
		
		List<ReservoirOperation> reservoirOperations = new ArrayList<>();
		reservoirOperations.add(new ReservoirOperation("1.10", 58, 1, 2, 3, 14, 52));
		reservoirOperations.add(new ReservoirOperation("2.10", 64, 1, 2, 3, 18, 54));
		reservoirOperations.add(new ReservoirOperation("3.10", 71, 1, 2, 4, 16, 60));
		reservoirOperations.add(new ReservoirOperation("4.10", 68, 1, 2, 3, 14, 70));
		reservoirOperations.add(new ReservoirOperation("5.10", 40, 2, 4, 5, 18, 46));
		reservoirOperations.add(new ReservoirOperation("6.10", 21, 2, 4, 4, 21, 35));
		reservoirOperations.add(new ReservoirOperation("7.10", 29.5f, 1.5f, 1, 3, 22, 75));
		reservoirOperations.add(new ReservoirOperation("8.10", 38, 2, 4, 4, 20, 77));
		reservoirOperations.add(new ReservoirOperation("9.10", 41, 2, 3, 3, 21, 82));
		reservoirOperations.add(new ReservoirOperation("10.10", 48, 2, 4, 4, 17, 89));
		reservoirOperations.add(new ReservoirOperation("11.10", 54, 2, 3, 4, 14, 87));
		reservoirOperations.add(new ReservoirOperation("12.10", 59, 1, 2, 2, 18, 90));
		
		System.err.println(reservoirOperations);
		
		return reservoirOperations;
	}
}

