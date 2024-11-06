package com.coderscampus;

public class JobsFilteringApplication
	{

		public static void main(String[] args)
			{
				JobService jobService = new JobService();

				jobService.readShowDocument("jobs.txt");

			}
	}
