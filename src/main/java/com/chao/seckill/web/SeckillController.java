package com.chao.seckill.web;

import com.chao.seckill.common.StateEnum;
import com.chao.seckill.dto.CommonResult;
import com.chao.seckill.dto.Exposer;
import com.chao.seckill.dto.SeckillExecution;
import com.chao.seckill.entity.Stock;
import com.chao.seckill.exception.OrderException;
import com.chao.seckill.service.StockService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    private StockService stockService;

    @GetMapping("/list")
    public String findAll(Model model){
        List<Stock> stocks = stockService.getStocks();
        model.addAttribute("list", stocks);
        return "list";
    }

    @GetMapping("/detail")
    public String detail(Long id, Model model){
        if(id == null || id.equals("")){
            return "redirect:/seckill/list";
        }
        Stock stock = stockService.getById(id);
        if(stock == null){
            return "forward:/seckill/list";
        }
        model.addAttribute("stock", stock);
        return "detail";
    }

    @GetMapping(value = "/{id}/exposer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public CommonResult<Exposer> exposer(long id){
        CommonResult<Exposer> result = null;
        try {
            Exposer exposer = stockService.exportSeckillUrl(id);
            result = new CommonResult<>(true, exposer);
        }catch (Exception e){
            result = new CommonResult<>(false, e.getMessage());
        }
        return result;
    }
    
    @GetMapping("/{id}/{token}/execution")
    @ResponseBody
    public CommonResult<SeckillExecution> execute(long id, String token, @CookieValue(value = "phpne", required = false) Long phone){
        CommonResult<SeckillExecution> result = null;
        if(phone == null){
            result = new CommonResult<>(false, "还未登录");
        }
        try {
            SeckillExecution seckillExecution = stockService.executeSeckill(id, phone, token);
            result = new CommonResult<>(true, seckillExecution);
        }catch (OrderException e){
            result = new CommonResult<>(false, e.getMessage());
        }catch (Exception e){
            result = new CommonResult<>(false, StateEnum.SYSTEM_ERROR.getStateInfo());
        }
        return result;
    }
}
