package edu.ssafy.business;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.model.MemVO;

public interface IMemService {
	public void logOut(HttpServletRequest request, HttpServletResponse response) throws IOException;

	public void logIn(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
	public void updatemem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	public void deleteMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	public void mainInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	public void listMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	public void registMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;
}
