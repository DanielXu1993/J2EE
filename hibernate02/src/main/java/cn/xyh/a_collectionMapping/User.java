package cn.xyh.a_collectionMapping;

import java.util.List;
import java.util.Map;
import java.util.Set;

// 集合中存储的是简单的类型，不能为对象类型
public class User {
    private int userId;
    private String userName;
    // 一个用户对应多个地址
    private Set<String> addressSet;
    private List<String> addressList;
    private Map<String, String> addressMap;

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<String> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<String> addressSet) {
        this.addressSet = addressSet;
    }

    public List<String> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<String> addressList) {
        this.addressList = addressList;
    }

    public Map<String, String> getAddressMap() {
        return addressMap;
    }

    public void setAddressMap(Map<String, String> addressMap) {
        this.addressMap = addressMap;
    }
}
