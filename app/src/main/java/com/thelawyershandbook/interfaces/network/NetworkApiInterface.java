package com.thelawyershandbook.interfaces.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Faraz on 6/6/2017.
 */

public interface NetworkApiInterface {

//    @Headers("Content-Type: application/json")
//    @POST("api/v1/users/signup")
//    public Call<UserModel> userSignUp(@Body User user);
//
//    @Headers("Content-Type: application/json")
//    @POST("api/v1/users/signin")
//    public Call<UserModel> userSignIn(@Body User user);
//
//    @Headers("Content-Type: application/json")
//    @PUT("api/v1/users/updateUser")
//    public Call<User> userUpdate(@Header("Authorization") String token, @Body UserModel user);
//
//    @Headers("Content-Type: application/json")
//    @POST("api/v1/users/resetpassword")
//    public Call<Void> userForgotPassword(@Body User user);
//
//    @GET("api/v1/employees/getAllEmployeesDetail")
//    Call<EmployeeModel> getEmployeeLsit(@Header("Authorization") String token,
//                                        @Query("limit") String limit,
//                                        @Query("offset") String offset,
//                                        @Query("branchId") String branchId,
//                                        @Query("fromDate") String startDate,
//                                        @Query("toDate") String endDate,
//                                        @Query("employee") String employee);
//
//    @GET("api/v1/branches/getbranches")
//    Call<List<Branch>> getBranchLsit(@Header("Authorization") String token,
//                                     @Query("limit") String limit,
//                                     @Query("offset") String offset);
//
//    @Headers("Content-Type: application/json")
//    @POST("api/v1/employees/createEmployee")
//    public Call<Employee> createEmployee(@Header("Authorization") String token, @Body Employee employee);
//
//    @Headers("Content-Type: application/json")
//    @POST("api/v1/branches/createBranch")
//    public Call<Branch> createBranch(@Header("Authorization") String token, @Body Branch employee);
//
//    @Headers("Content-Type: application/json")
//    @DELETE("/api/v1/branches/deleteBranchById/{id}")
//    public Call<Void> deleteBranch(@Header("Authorization") String token, @Path("id") String itemId);
//
//    @Headers("Content-Type: application/json")
//    @GET("/api/v1/employees/getEmployeeDetailById/{id}")
//    public Call<Employee> getEmployee(@Header("Authorization") String token, @Path("id") String itemId);
//
//    @Headers("Content-Type: application/json")
//    @PUT("/api/v1/branches/updateBranch")
//    public Call<Branch> updateBranch(@Header("Authorization") String token, @Body BranchRootModel branch);
//
//    @Headers("Content-Type: application/json")
//    @PUT("/api/v1/branches/resendInviteToManager")
//    public Call<Void> resendBranch(@Header("Authorization") String token, @Body Branch branch);
//
//    @Headers("Content-Type: application/json")
//    @PUT("/api/v1/employees/updateEmployee")
//    public Call<Employee> updateEmployee(@Header("Authorization") String token, @Body EmployeeModel employeeModel);
//
//    @Headers("Content-Type: application/json")
//    @PUT("/api/v1/users/updatePassword")
//    public Call<Void> updatePassword(@Header("Authorization") String token, @Body UserModel userModel);


    @Headers("Content-Type: application/json")
    @DELETE("/api/v1/employees/deleteEmployeeById/{id}")
    public Call<Void> deleteEmployee(@Header("Authorization") String token, @Path("id") String itemId);
}
