/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
//chứa các hàm xử lí dữ liệu
//không làm việc trực tiếp với csdl
//làm việc thông qua lớp HangHoaConnect
import Connections.HangHoaConnection;
import java.util.List;
import Model.HangHoa;


/**
 *
 * @author Asus
 */
public class HangHoaService {
    private final HangHoaConnection HangHoaCn;
    public HangHoaService(){
        HangHoaCn = new HangHoaConnection();
    }
    public List<HangHoa> getALLHangHoa(){
        return HangHoaCn.getAllHangHoa();//trả về dữ liệu
    }
    
    public HangHoa getHangHoa(String idSP){
        return HangHoaConnection.getHangHoa(idSP);
    }
    
    public void delete(String idSP){
        HangHoaConnection.delete(idSP);
    }
   
    public void update(HangHoa hh){
        HangHoaConnection.update(hh);
    }
    
    
}

