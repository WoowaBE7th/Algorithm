package main;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = bf.readLine();
		
		String[] arr = input.split(" ");
		int answer = solution(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
		
		System.out.println(answer);
		
		bf.close();
	}
	
	private static int solution(int N, int K) {
		int result = 0;
		int[] arr = new int[N+1];
		for(int i = 0; i < N+1; i++) {
			arr[i] = i;
		}
		
		int cnt = 0;
		for(int i = 2; i <= N && cnt != K; i++) {
			
			for(int j = 1; j*i < N+1; j++) {
				if(arr[j*i] != 0 && arr[j*i] % i == 0) {
					cnt++;
					if(cnt == K) {
						result = arr[j*i];
						break;
					}
					arr[j*i] = 0;
				}
				
			}
		}
		
		return result;
	}

}
